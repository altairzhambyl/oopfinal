package NewNav;

import Database.DB;
import Enums.Language;
import Notifications.Message;
import Users.Employee;
import Users.User;

import java.util.List;
import java.util.Vector;

public class NotificationPage extends Page {
    private UserSession session;

    public NotificationPage() {
        this.session = UserSession.getInstance();
    }

    @Override
    public void display() {
        User currentUser = session.getCurrentUser();
        if (currentUser == null) {
            if (Page.language == Language.EN) {
                System.out.println("No user is logged in. Please log in first.");
            } else if (Page.language == Language.RU) {
                System.out.println("Пользователь не авторизован. Пожалуйста, войдите в систему.");
            } else if (Page.language == Language.KZ) {
                System.out.println("Пайдаланушы жүйеге кірмеген. Алдымен жүйеге кіріңіз.");
            }
            return;
        }

        if (Page.language == Language.EN) {
            System.out.println("\n=== Notification Page ===");
            System.out.println("Recent Messages:");
        } else if (Page.language == Language.RU) {
            System.out.println("\n=== Страница уведомлений ===");
            System.out.println("Последние сообщения:");
        } else if (Page.language == Language.KZ) {
            System.out.println("\n=== Хабарландыру беті ===");
            System.out.println("Соңғы хабарламалар:");
        }

        Vector<Message> allMessages = DB.getInstance().getMessages();
        boolean hasMessages = false;

        for (Message message : allMessages) {
            if (message.getReciever().equals(currentUser)) {
                System.out.println(message);
                hasMessages = true;
            }
        }

        if (!hasMessages) {
            if (Page.language == Language.EN) {
                System.out.println("No messages found.");
            } else if (Page.language == Language.RU) {
                System.out.println("Сообщений не найдено.");
            } else if (Page.language == Language.KZ) {
                System.out.println("Хабарламалар табылмады.");
            }
        }
    }

    @Override
    public void navigate() {
        if (Page.language == Language.EN) {
            System.out.println("\nOptions:");
            System.out.println("1. Send a Message");
            System.out.println("-1. Back to Home Page");
        } else if (Page.language == Language.RU) {
            System.out.println("\nОпции:");
            System.out.println("1. Отправить сообщение");
            System.out.println("-1. Вернуться на главную страницу");
        } else if (Page.language == Language.KZ) {
            System.out.println("\nМүмкіндіктер:");
            System.out.println("1. Хабарлама жіберу");
            System.out.println("-1. Басты бетке оралу");
        }

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                sendMessage();
                break;
            case -1:
                new HomePage().start();
                break;
            default:
                if (Page.language == Language.EN) {
                    System.out.println("Invalid choice! Please try again.");
                } else if (Page.language == Language.RU) {
                    System.out.println("Неверный выбор! Пожалуйста, попробуйте снова.");
                } else if (Page.language == Language.KZ) {
                    System.out.println("Қате таңдау! Қайтадан көріңізші.");
                }
                navigate();
        }
    }

    @Override
    public void start() {
        display();
        navigate();
    }

    private void sendMessage() {
        User currentUser = session.getCurrentUser();

        if (!(currentUser instanceof Employee)) {
            if (Page.language == Language.EN) {
                System.out.println("Only employees can send messages.");
            } else if (Page.language == Language.RU) {
                System.out.println("Только сотрудники могут отправлять сообщения.");
            } else if (Page.language == Language.KZ) {
                System.out.println("Тек қызметкерлер ғана хабарлама жібере алады.");
            }
            return;
        }

        if (Page.language == Language.EN) {
            System.out.println("Enter the recipient's email: ");
        } else if (Page.language == Language.RU) {
            System.out.println("Введите email получателя: ");
        } else if (Page.language == Language.KZ) {
            System.out.println("Алушының электрондық поштасын енгізіңіз: ");
        }

        String recipientEmail = scanner.nextLine();

//        if (recipient == null || !(recipient instanceof Employee)) {
//            if (Page.language == Language.EN) {
//                System.out.println("Recipient not found or not an employee.");
//            } else if (Page.language == Language.RU) {
//                System.out.println("Получатель не найден или не является сотрудником.");
//            } else if (Page.language == Language.KZ) {
//                System.out.println("Алушы табылмады немесе қызметкер емес.");
//            }
//            return;
//        }

        if (Page.language == Language.EN) {
            System.out.println("Enter your message: ");
        } else if (Page.language == Language.RU) {
            System.out.println("Введите ваше сообщение: ");
        } else if (Page.language == Language.KZ) {
            System.out.println("Хабарламаңызды енгізіңіз: ");
        }

        String messageContent = scanner.nextLine();

        if (messageContent.isEmpty()) {
            if (Page.language == Language.EN) {
                System.out.println("Message content cannot be empty.");
            } else if (Page.language == Language.RU) {
                System.out.println("Содержимое сообщения не может быть пустым.");
            } else if (Page.language == Language.KZ) {
                System.out.println("Хабарлама мазмұны бос болмауы керек.");
            }
            return;
        }

        User recipient = DB.getInstance().getUserByUsername(recipientEmail);
        Message message = new Message(
                DB.getInstance().getMessages().size() + 1,
                messageContent,
                currentUser,
                recipient
        );

        DB.getInstance().addMessage(message);

        if (Page.language == Language.EN) {
            System.out.println("Message sent successfully!");
        } else if (Page.language == Language.RU) {
            System.out.println("Сообщение успешно отправлено!");
        } else if (Page.language == Language.KZ) {
            System.out.println("Хабарлама сәтті жіберілді!");
        }
    }
}
