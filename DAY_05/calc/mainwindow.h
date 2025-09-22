#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>

QT_BEGIN_NAMESPACE
namespace Ui {
class MainWindow;
}
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    MainWindow(QWidget *parent = nullptr);
    ~MainWindow();

private:
    Ui::MainWindow *ui;
    double fnum;
    bool type_secnum = false;
    QString next_operator = "";
private slots:
    void pushed_buttons();
    void on_pushButton_dot_released();
    void toggle_sign();
    void percent_pressed();
    void ce();
    void operator_pressed();
    void equal();
};
#endif // MAINWINDOW_H
