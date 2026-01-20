# 贪吃蛇游戏 - 网页版

这是一个使用纯 HTML、CSS 和 JavaScript 开发的经典贪吃蛇游戏。

## 🎮 游戏特点

- ✨ 精美的现代化界面设计
- 🎯 流畅的游戏体验
- 📱 支持响应式布局
- 🎨 动态网格背景
- 👀 蛇头带有方向性的眼睛
- ⏸️ 支持暂停/继续功能
- 🔄 可随时重新开始

## 🕹️ 游戏操作

- **方向键 ↑↓←→**：控制蛇的移动方向
- **空格键**：
  - 初始状态：开始游戏
  - 游戏中：暂停/继续
  - 游戏结束：重新开始

## 🚀 本地运行

直接用浏览器打开 `index.html` 文件即可开始游戏。

## 🌐 部署到网上

### 方法 1：GitHub Pages（推荐）

1. **创建 GitHub 账号**（如果还没有）
   - 访问 https://github.com/signup
   - 注册一个免费账号

2. **创建新仓库**
   - 登录后点击右上角的 `+` → `New repository`
   - 仓库名填写：`snake-game`（可以自定义）
   - 选择 `Public`（公开）
   - 点击 `Create repository`

3. **上传文件**
   - 在本地项目根目录（`D:\javaproject\hello`）打开命令行
   - 运行以下命令：

   ```bash
   # 初始化 git 仓库
   git init
   
   # 添加文件
   git add web/
   
   # 提交
   git commit -m "Add snake game"
   
   # 关联远程仓库（替换 YOUR_USERNAME 为你的 GitHub 用户名）
   git remote add origin https://github.com/YOUR_USERNAME/snake-game.git
   
   # 推送代码
   git branch -M main
   git push -u origin main
   ```

4. **启用 GitHub Pages**
   - 在 GitHub 仓库页面，点击 `Settings`
   - 左侧菜单找到 `Pages`
   - Source 选择 `main` 分支
   - 文件夹选择 `/web` 或 `/root`
   - 点击 `Save`
   - 等待几分钟后，你的网站就会发布到：
     `https://YOUR_USERNAME.github.io/snake-game/`

### 方法 2：Vercel（最快速）

1. **注册 Vercel**
   - 访问 https://vercel.com/signup
   - 使用 GitHub 账号登录

2. **导入项目**
   - 点击 `New Project`
   - 选择你的 GitHub 仓库
   - 配置：
     - Root Directory: `web`
     - 其他保持默认
   - 点击 `Deploy`

3. **获取网址**
   - 部署完成后会自动生成网址，格式：`https://your-project.vercel.app`
   - 可以自定义域名

### 方法 3：Netlify

1. **注册 Netlify**
   - 访问 https://www.netlify.com/
   - 点击 `Sign up` 注册

2. **拖拽部署**
   - 登录后进入控制台
   - 直接将 `web` 文件夹拖拽到页面上
   - 自动部署，生成网址

3. **或通过 GitHub**
   - 点击 `New site from Git`
   - 选择 GitHub
   - 选择仓库
   - Base directory: `web`
   - 点击 `Deploy site`

### 方法 4：Gitee Pages（国内访问快）

1. **注册 Gitee**
   - 访问 https://gitee.com/signup
   - 注册免费账号

2. **创建仓库并推送代码**
   - 创建新仓库（类似 GitHub）
   - 推送代码到 Gitee

3. **开启 Gitee Pages**
   - 仓库页面点击 `服务` → `Gitee Pages`
   - 选择部署分支和目录
   - 点击 `启动`
   - 网址格式：`https://YOUR_USERNAME.gitee.io/snake-game`

## 📦 文件说明

- `index.html` - 游戏主文件，包含完整的游戏逻辑
- `snake.html` - 游戏的另一个版本

## 🎯 技术栈

- HTML5 Canvas
- CSS3（渐变、动画、响应式布局）
- 原生 JavaScript（无依赖）

## 📝 许可

MIT License - 可自由使用和修改
