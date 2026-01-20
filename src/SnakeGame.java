import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {
    private static final int BOARD_WIDTH = 600;
    private static final int BOARD_HEIGHT = 600;
    private static final int UNIT_SIZE = 25;
    private static final int GAME_UNITS = (BOARD_WIDTH * BOARD_HEIGHT) / UNIT_SIZE;
    private static final int DELAY = 100;

    private ArrayList<Point> snake;
    private Point food;
    private char direction = 'R'; // R=Right, L=Left, U=Up, D=Down
    private boolean running = false;
    private Timer timer;
    private Random random;
    private int score = 0;

    public SnakeGame() {
        random = new Random();
        this.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(this);
        startGame();
    }

    public void startGame() {
        snake = new ArrayList<>();
        snake.add(new Point(0, 0));
        snake.add(new Point(0, UNIT_SIZE));
        snake.add(new Point(0, UNIT_SIZE * 2));
        
        direction = 'R';
        running = true;
        score = 0;
        
        newFood();
        
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            // 绘制网格线（可选）
            g.setColor(Color.DARK_GRAY);
            for (int i = 0; i < BOARD_HEIGHT / UNIT_SIZE; i++) {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, BOARD_HEIGHT);
                g.drawLine(0, i * UNIT_SIZE, BOARD_WIDTH, i * UNIT_SIZE);
            }

            // 绘制食物
            g.setColor(Color.RED);
            g.fillOval(food.x, food.y, UNIT_SIZE, UNIT_SIZE);

            // 绘制蛇
            for (int i = 0; i < snake.size(); i++) {
                if (i == 0) {
                    // 蛇头
                    g.setColor(Color.GREEN);
                } else {
                    // 蛇身
                    g.setColor(new Color(45, 180, 0));
                }
                g.fillRect(snake.get(i).x, snake.get(i).y, UNIT_SIZE, UNIT_SIZE);
            }

            // 绘制分数
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            FontMetrics metrics = g.getFontMetrics();
            g.drawString("分数: " + score, 
                (BOARD_WIDTH - metrics.stringWidth("分数: " + score)) / 2, 
                g.getFont().getSize());
        } else {
            gameOver(g);
        }
    }

    public void newFood() {
        boolean valid = false;
        while (!valid) {
            int x = random.nextInt(BOARD_WIDTH / UNIT_SIZE) * UNIT_SIZE;
            int y = random.nextInt(BOARD_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
            food = new Point(x, y);
            
            valid = true;
            for (Point segment : snake) {
                if (segment.equals(food)) {
                    valid = false;
                    break;
                }
            }
        }
    }

    public void move() {
        Point head = new Point(snake.get(0));
        
        switch (direction) {
            case 'U':
                head.y -= UNIT_SIZE;
                break;
            case 'D':
                head.y += UNIT_SIZE;
                break;
            case 'L':
                head.x -= UNIT_SIZE;
                break;
            case 'R':
                head.x += UNIT_SIZE;
                break;
        }

        // 检查是否吃到食物
        if (head.equals(food)) {
            snake.add(0, head);
            score++;
            newFood();
        } else {
            snake.add(0, head);
            snake.remove(snake.size() - 1);
        }
    }

    public void checkCollisions() {
        Point head = snake.get(0);

        // 检查是否撞墙
        if (head.x < 0 || head.x >= BOARD_WIDTH || 
            head.y < 0 || head.y >= BOARD_HEIGHT) {
            running = false;
        }

        // 检查是否撞到自己
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                running = false;
                break;
            }
        }

        if (!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {
        // 绘制最终分数
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        FontMetrics metrics1 = g.getFontMetrics();
        g.drawString("游戏结束!", 
            (BOARD_WIDTH - metrics1.stringWidth("游戏结束!")) / 2, 
            BOARD_HEIGHT / 2 - 40);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics metrics2 = g.getFontMetrics();
        g.drawString("最终分数: " + score, 
            (BOARD_WIDTH - metrics2.stringWidth("最终分数: " + score)) / 2, 
            BOARD_HEIGHT / 2 + 20);

        g.drawString("按空格键重新开始", 
            (BOARD_WIDTH - metrics2.stringWidth("按空格键重新开始")) / 2, 
            BOARD_HEIGHT / 2 + 60);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkCollisions();
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (!running && key == KeyEvent.VK_SPACE) {
            startGame();
            return;
        }

        if (running) {
            switch (key) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("贪吃蛇游戏");
        SnakeGame game = new SnakeGame();
        
        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}