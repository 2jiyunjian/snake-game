@echo off
chcp 65001 >nul
echo ========================================
echo 贪吃蛇游戏 - 自动部署脚本
echo ========================================
echo.

REM 检查是否安装了 git
where git >nul 2>nul
if %ERRORLEVEL% NEQ 0 (
    echo [错误] 未检测到 Git，请先安装 Git
    echo 下载地址: https://git-scm.com/download/win
    pause
    exit /b 1
)

echo [1/5] 检查 Git 环境...
echo Git 已安装 ✓
echo.

REM 检查是否已经初始化 git
if not exist ".git" (
    echo [2/5] 初始化 Git 仓库...
    git init
    echo Git 仓库初始化完成 ✓
    echo.
) else (
    echo [2/5] Git 仓库已存在 ✓
    echo.
)

echo [3/5] 添加文件到 Git...
git add web/ .gitignore
echo 文件添加完成 ✓
echo.

echo [4/5] 创建提交...
git commit -m "Add snake game web version"
if %ERRORLEVEL% EQU 0 (
    echo 提交创建完成 ✓
) else (
    echo 没有需要提交的更改
)
echo.

echo [5/5] 准备推送到 GitHub...
echo.
echo ========================================
echo 接下来的步骤：
echo ========================================
echo.
echo 1. 如果还没有 GitHub 账号，请访问：
echo    https://github.com/signup
echo.
echo 2. 在 GitHub 上创建新仓库（New repository）：
echo    - 仓库名建议：snake-game
echo    - 选择 Public（公开）
echo.
echo 3. 复制仓库的 HTTPS 地址，类似：
echo    https://github.com/你的用户名/snake-game.git
echo.
set /p repo_url="请输入你的 GitHub 仓库地址（或按回车跳过）: "

if "%repo_url%"=="" (
    echo.
    echo 已跳过自动推送
    echo.
    echo 你可以稍后手动执行：
    echo   git remote add origin 你的仓库地址
    echo   git branch -M main
    echo   git push -u origin main
    goto :manual_steps
)

echo.
echo 正在关联远程仓库...
git remote remove origin 2>nul
git remote add origin %repo_url%
git branch -M main

echo.
echo 正在推送到 GitHub...
git push -u origin main

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ========================================
    echo 推送成功！✓
    echo ========================================
    goto :enable_pages
) else (
    echo.
    echo [警告] 推送失败，可能需要配置 Git 凭据
    echo.
    echo 请尝试手动执行：
    echo   git push -u origin main
    goto :manual_steps
)

:enable_pages
echo.
echo 最后一步：启用 GitHub Pages
echo.
echo 1. 访问你的 GitHub 仓库页面
echo 2. 点击 "Settings" （设置）
echo 3. 左侧菜单找到 "Pages"
echo 4. Source 选择 "main" 分支
echo 5. 文件夹选择 "/web" 或 "/root"
echo 6. 点击 "Save" 保存
echo.
echo 等待几分钟后，你的游戏网址会是：
echo https://你的用户名.github.io/仓库名/
echo.
goto :end

:manual_steps
echo.
echo ========================================
echo 手动部署步骤：
echo ========================================
echo.
echo 1. 创建 GitHub 仓库（如果还没有）
echo 2. 执行以下命令：
echo.
echo    git remote add origin https://github.com/你的用户名/仓库名.git
echo    git branch -M main
echo    git push -u origin main
echo.
echo 3. 在 GitHub 仓库设置中启用 Pages
echo.

:end
echo ========================================
echo 部署脚本执行完成
echo ========================================
echo.
echo 如有问题，请查看 web\README.md 获取详细说明
echo.
pause
