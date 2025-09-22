/********************************************************************************
** Form generated from reading UI file 'mainwindow.ui'
**
** Created by: Qt User Interface Compiler version 6.9.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_MAINWINDOW_H
#define UI_MAINWINDOW_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QLabel>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_MainWindow
{
public:
    QWidget *centralwidget;
    QLabel *label;
    QPushButton *pushButton_CE;
    QPushButton *pushButton_posneg;
    QPushButton *pushButton_percent;
    QPushButton *pushButton_plus;
    QPushButton *pushButton_8;
    QPushButton *pushButton_minus;
    QPushButton *pushButton_9;
    QPushButton *pushButton_7;
    QPushButton *pushButton_6;
    QPushButton *pushButton_5;
    QPushButton *pushButton_multi;
    QPushButton *pushButton_4;
    QPushButton *pushButton_div;
    QPushButton *pushButton_3;
    QPushButton *pushButton_1;
    QPushButton *pushButton_2;
    QPushButton *pushButton_0;
    QPushButton *pushButton_dot;
    QPushButton *pushButton_equal;

    void setupUi(QMainWindow *MainWindow)
    {
        if (MainWindow->objectName().isEmpty())
            MainWindow->setObjectName("MainWindow");
        MainWindow->resize(241, 252);
        MainWindow->setMaximumSize(QSize(500, 400));
        MainWindow->setStyleSheet(QString::fromUtf8("QMainWindow{\n"
"      background-color:gray;\n"
"}"));
        centralwidget = new QWidget(MainWindow);
        centralwidget->setObjectName("centralwidget");
        label = new QLabel(centralwidget);
        label->setObjectName("label");
        label->setGeometry(QRect(0, 0, 241, 51));
        label->setMaximumSize(QSize(400, 400));
        QFont font;
        label->setFont(font);
        label->setStyleSheet(QString::fromUtf8("QLabel {\n"
"    color: white;\n"
"    background-color: black;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 20px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignRight';\n"
"}\n"
"QLabel::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}\n"
"QLabel::pressed{\n"
"    background-color: gray;  \n"
"    border: 2px solid black;  \n"
"    \n"
"}"));
        pushButton_CE = new QPushButton(centralwidget);
        pushButton_CE->setObjectName("pushButton_CE");
        pushButton_CE->setGeometry(QRect(0, 50, 60, 41));
        pushButton_CE->setMaximumSize(QSize(60, 60));
        pushButton_CE->setFont(font);
        pushButton_CE->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: black;\n"
"    background-color: white;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}\n"
"QPushButton::pressed{\n"
"    color:white;\n"
"    background-color: black;  \n"
"    border: 2px solid white;  \n"
"    border-radius: 10;\n"
"}"));
        pushButton_posneg = new QPushButton(centralwidget);
        pushButton_posneg->setObjectName("pushButton_posneg");
        pushButton_posneg->setGeometry(QRect(60, 50, 60, 41));
        pushButton_posneg->setMaximumSize(QSize(60, 60));
        pushButton_posneg->setFont(font);
        pushButton_posneg->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: black;\n"
"    background-color: white;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}\n"
"QPushButton::pressed{\n"
"    color:white;\n"
"    background-color: black;  \n"
"    border: 2px solid white;  \n"
"    border-radius: 10;\n"
"}"));
        pushButton_percent = new QPushButton(centralwidget);
        pushButton_percent->setObjectName("pushButton_percent");
        pushButton_percent->setGeometry(QRect(120, 50, 60, 41));
        pushButton_percent->setMaximumSize(QSize(60, 60));
        pushButton_percent->setFont(font);
        pushButton_percent->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: black;\n"
"    background-color: white;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}\n"
"QPushButton::pressed{\n"
"    color:white;\n"
"    background-color: black;  \n"
"    border: 2px solid white;  \n"
"    border-radius: 10;\n"
"}"));
        pushButton_plus = new QPushButton(centralwidget);
        pushButton_plus->setObjectName("pushButton_plus");
        pushButton_plus->setGeometry(QRect(180, 50, 60, 41));
        pushButton_plus->setMaximumSize(QSize(60, 60));
        pushButton_plus->setFont(font);
        pushButton_plus->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: black;\n"
"    background-color: white;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}\n"
"QPushButton::pressed{\n"
"    color:white;\n"
"    background-color: black;  \n"
"    border: 2px solid white;  \n"
"    border-radius: 10;\n"
"}"));
        pushButton_plus->setCheckable(true);
        pushButton_8 = new QPushButton(centralwidget);
        pushButton_8->setObjectName("pushButton_8");
        pushButton_8->setGeometry(QRect(60, 90, 60, 41));
        pushButton_8->setMaximumSize(QSize(60, 60));
        pushButton_8->setFont(font);
        pushButton_8->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: white;\n"
"    background-color: black;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}"));
        pushButton_minus = new QPushButton(centralwidget);
        pushButton_minus->setObjectName("pushButton_minus");
        pushButton_minus->setGeometry(QRect(180, 90, 60, 41));
        pushButton_minus->setMaximumSize(QSize(60, 60));
        pushButton_minus->setFont(font);
        pushButton_minus->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: black;\n"
"    background-color: white;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}\n"
"QPushButton::pressed{\n"
"    color:white;\n"
"    background-color: black;  \n"
"    border: 2px solid white;  \n"
"    border-radius: 10;\n"
"}"));
        pushButton_minus->setCheckable(true);
        pushButton_9 = new QPushButton(centralwidget);
        pushButton_9->setObjectName("pushButton_9");
        pushButton_9->setGeometry(QRect(120, 90, 60, 41));
        pushButton_9->setMaximumSize(QSize(60, 60));
        pushButton_9->setFont(font);
        pushButton_9->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: white;\n"
"    background-color: black;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}"));
        pushButton_7 = new QPushButton(centralwidget);
        pushButton_7->setObjectName("pushButton_7");
        pushButton_7->setGeometry(QRect(0, 90, 60, 41));
        pushButton_7->setMaximumSize(QSize(60, 60));
        pushButton_7->setFont(font);
        pushButton_7->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: white;\n"
"    background-color: black;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}"));
        pushButton_6 = new QPushButton(centralwidget);
        pushButton_6->setObjectName("pushButton_6");
        pushButton_6->setGeometry(QRect(120, 130, 60, 41));
        pushButton_6->setMaximumSize(QSize(60, 60));
        pushButton_6->setFont(font);
        pushButton_6->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: white;\n"
"    background-color: black;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}"));
        pushButton_5 = new QPushButton(centralwidget);
        pushButton_5->setObjectName("pushButton_5");
        pushButton_5->setGeometry(QRect(60, 130, 60, 41));
        pushButton_5->setMaximumSize(QSize(60, 60));
        pushButton_5->setFont(font);
        pushButton_5->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: white;\n"
"    background-color: black;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}"));
        pushButton_multi = new QPushButton(centralwidget);
        pushButton_multi->setObjectName("pushButton_multi");
        pushButton_multi->setGeometry(QRect(180, 130, 60, 41));
        pushButton_multi->setMaximumSize(QSize(60, 60));
        pushButton_multi->setFont(font);
        pushButton_multi->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: black;\n"
"    background-color: white;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}\n"
"QPushButton::pressed{\n"
"    color:white;\n"
"    background-color: black;  \n"
"    border: 2px solid white;  \n"
"    border-radius: 10;\n"
"}"));
        pushButton_multi->setCheckable(true);
        pushButton_4 = new QPushButton(centralwidget);
        pushButton_4->setObjectName("pushButton_4");
        pushButton_4->setGeometry(QRect(0, 130, 60, 41));
        pushButton_4->setMaximumSize(QSize(60, 60));
        pushButton_4->setFont(font);
        pushButton_4->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: white;\n"
"    background-color: black;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}"));
        pushButton_div = new QPushButton(centralwidget);
        pushButton_div->setObjectName("pushButton_div");
        pushButton_div->setGeometry(QRect(180, 170, 60, 41));
        pushButton_div->setMaximumSize(QSize(60, 60));
        pushButton_div->setFont(font);
        pushButton_div->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: black;\n"
"    background-color: white;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}\n"
"QPushButton::pressed{\n"
"    color:white;\n"
"    background-color: black;  \n"
"    border: 2px solid white;  \n"
"    border-radius: 10;\n"
"}"));
        pushButton_div->setCheckable(true);
        pushButton_3 = new QPushButton(centralwidget);
        pushButton_3->setObjectName("pushButton_3");
        pushButton_3->setGeometry(QRect(120, 170, 60, 41));
        pushButton_3->setMaximumSize(QSize(60, 60));
        pushButton_3->setFont(font);
        pushButton_3->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: white;\n"
"    background-color: black;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}"));
        pushButton_1 = new QPushButton(centralwidget);
        pushButton_1->setObjectName("pushButton_1");
        pushButton_1->setGeometry(QRect(0, 170, 60, 41));
        pushButton_1->setMaximumSize(QSize(60, 60));
        pushButton_1->setFont(font);
        pushButton_1->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: white;\n"
"    background-color: black;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}"));
        pushButton_2 = new QPushButton(centralwidget);
        pushButton_2->setObjectName("pushButton_2");
        pushButton_2->setGeometry(QRect(60, 170, 60, 41));
        pushButton_2->setMaximumSize(QSize(60, 60));
        pushButton_2->setFont(font);
        pushButton_2->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: white;\n"
"    background-color: black;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}"));
        pushButton_0 = new QPushButton(centralwidget);
        pushButton_0->setObjectName("pushButton_0");
        pushButton_0->setGeometry(QRect(0, 210, 120, 41));
        pushButton_0->setMaximumSize(QSize(120, 60));
        pushButton_0->setFont(font);
        pushButton_0->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: white;\n"
"    background-color: black;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}"));
        pushButton_dot = new QPushButton(centralwidget);
        pushButton_dot->setObjectName("pushButton_dot");
        pushButton_dot->setGeometry(QRect(120, 210, 60, 41));
        pushButton_dot->setMaximumSize(QSize(60, 60));
        pushButton_dot->setFont(font);
        pushButton_dot->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: white;\n"
"    background-color: black;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}"));
        pushButton_equal = new QPushButton(centralwidget);
        pushButton_equal->setObjectName("pushButton_equal");
        pushButton_equal->setGeometry(QRect(180, 210, 60, 41));
        pushButton_equal->setMaximumSize(QSize(60, 60));
        pushButton_equal->setFont(font);
        pushButton_equal->setStyleSheet(QString::fromUtf8("QPushButton {\n"
"    color: black;\n"
"    background-color: white;\n"
"    font-size: 20px;\n"
"    border: 2px solid #555555;\n"
"    border-radius: 15px;\n"
"    padding: 5px;\n"
"    qproperty-alignment: 'AlignCenter';\n"
"    margin:5px;\n"
"}\n"
"QPushButton::hover{\n"
"    background-color: #2e2e2e;  \n"
"    border: 2px solid white;  \n"
"}\n"
"QPushButton::pressed{\n"
"    color:white;\n"
"    background-color: black;  \n"
"    border: 2px solid white;  \n"
"    border-radius: 10;\n"
"}"));
        pushButton_equal->setCheckable(true);
        MainWindow->setCentralWidget(centralwidget);

        retranslateUi(MainWindow);

        QMetaObject::connectSlotsByName(MainWindow);
    } // setupUi

    void retranslateUi(QMainWindow *MainWindow)
    {
        MainWindow->setWindowTitle(QCoreApplication::translate("MainWindow", "MainWindow", nullptr));
        label->setText(QCoreApplication::translate("MainWindow", "0", nullptr));
        pushButton_CE->setText(QCoreApplication::translate("MainWindow", "CE", nullptr));
        pushButton_posneg->setText(QCoreApplication::translate("MainWindow", "+/-", nullptr));
        pushButton_percent->setText(QCoreApplication::translate("MainWindow", "%", nullptr));
        pushButton_plus->setText(QCoreApplication::translate("MainWindow", "+", nullptr));
        pushButton_8->setText(QCoreApplication::translate("MainWindow", "8", nullptr));
        pushButton_minus->setText(QCoreApplication::translate("MainWindow", "-", nullptr));
        pushButton_9->setText(QCoreApplication::translate("MainWindow", "9", nullptr));
        pushButton_7->setText(QCoreApplication::translate("MainWindow", "7", nullptr));
        pushButton_6->setText(QCoreApplication::translate("MainWindow", "6", nullptr));
        pushButton_5->setText(QCoreApplication::translate("MainWindow", "5", nullptr));
        pushButton_multi->setText(QCoreApplication::translate("MainWindow", "*", nullptr));
        pushButton_4->setText(QCoreApplication::translate("MainWindow", "4", nullptr));
        pushButton_div->setText(QCoreApplication::translate("MainWindow", "/", nullptr));
        pushButton_3->setText(QCoreApplication::translate("MainWindow", "3", nullptr));
        pushButton_1->setText(QCoreApplication::translate("MainWindow", "1", nullptr));
        pushButton_2->setText(QCoreApplication::translate("MainWindow", "2", nullptr));
        pushButton_0->setText(QCoreApplication::translate("MainWindow", "0", nullptr));
        pushButton_dot->setText(QCoreApplication::translate("MainWindow", ".", nullptr));
        pushButton_equal->setText(QCoreApplication::translate("MainWindow", "=", nullptr));
    } // retranslateUi

};

namespace Ui {
    class MainWindow: public Ui_MainWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MAINWINDOW_H
