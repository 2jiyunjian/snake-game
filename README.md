# 🐍 贪吃蛇游戏 Snake Game

一个经典的贪吃蛇游戏，包含 **Java 桌面版** 和 **网页版** 两个版本。

## 🎮 在线试玩

👉 **[点击这里在线玩](https://2jiyunjian.github.io/snake-game/)** （网页版）

## 📦 项目结构

```
├── src/                 # Java 源代码
│   ├── SnakeGame.java  # Java Swing 桌面版游戏
│   └── App.java        # 示例程序
├── web/                 # 网页版
│   ├── index.html      # 网页版游戏（带难度选择）
│   ├── snake.html      # 网页版游戏（原始版本）
│   └── README.md       # 详细部署文档
├── bin/                 # Java 编译输出
└── lib/                 # Java 依赖库
```

## 🎯 游戏特点

### 网页版特点
- ✨ 现代化的 UI 设计（渐变背景、动画效果）
- 🎮 两种难度模式：简单（绿色蛇）、困难（红色蛇）
- 🐍 带方向性眼睛的生动蛇头
- ⏸️ 支持暂停/继续功能
- 📱 响应式设计，支持不同屏幕
- 🚀 纯前端，无需服务器

### Java 版特点
- 🖥️ 使用 Java Swing 开发
- 🎨 经典的桌面游戏界面
- 🎯 完整的游戏逻辑和碰撞检测

## 🕹️ 游戏操作

- **方向键 ↑↓←→** - 控制蛇的移动
- **空格键** - 开始/暂停/重新开始游戏
- **难度切换** - 点击界面上的难度按钮（网页版）

## 🚀 快速开始

### 网页版（推荐）

**方法 1：直接打开**
```bash
双击打开 web/index.html 文件
```

**方法 2：部署到网上**
- 详细部署说明请查看 [web/README.md](web/README.md)
- 支持 GitHub Pages、Vercel、Netlify 等平台

### Java 版

**编译和运行：**
```bash
# 编译
javac -encoding UTF-8 src/SnakeGame.java

# 运行
java -cp src SnakeGame
```

## 📝 开发说明

### 技术栈

**网页版：**
- HTML5 Canvas
- CSS3（渐变、动画）
- 原生 JavaScript（无框架依赖）

**Java 版：**
- Java Swing
- AWT 事件处理
- Timer 定时器

### 文件说明

- `src/SnakeGame.java` - Java 桌面版游戏主文件
- `web/index.html` - 网页版游戏（包含难度选择）
- `deploy.bat` - Windows 自动部署脚本
- `.gitignore` - Git 忽略文件配置

## 🌐 部署到互联网

使用自动部署脚本：
```bash
双击运行 deploy.bat
```

或手动部署到 GitHub Pages：
```bash
git add .
git commit -m "Add snake game"
git push origin main

# 然后在 GitHub 仓库设置中启用 Pages
```

详细部署教程请查看 [web/部署说明.txt](web/部署说明.txt)

## 📄 许可证

MIT License - 可自由使用和修改

## 🎓 学习资源

这个项目适合：
- Java 初学者学习 Swing GUI 编程
- 前端开发者学习 Canvas 游戏开发
- 了解同一游戏的不同技术实现

## 🤝 贡献

欢迎提交 Issue 和 Pull Request！

---

**祝你游戏愉快！🎉**
