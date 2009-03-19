/*  FreeNote for Sharp SLA300, B500, C7x0, C860 Linux PDA
	Copyright (C) 2003-2005 Joe Kanemori.<kanemori@ymg.urban.ne.jp>

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/
/*
2005/02/27 FreeNote 1.11.10pre
・PDFの出力形式を一部変更
・インポート時のバグfix

2004/10/17 FreeNote 1.10.0リリース
2003/08/15 FreeNote 1.2.1を公開
・保存時のバグ修正
・完了ダイアログの自動消去
・PNGファイルへの出力
*/
#include "fnmessagebox.h"
int ___fnmessagebox_timing = 1500;

FNMessageBox::FNMessageBox(QWidget *parent, const char* name) : QMessageBox(parent, name)
{
	_timer = new QTimer(this);
	connect(_timer, SIGNAL(timeout()), this, SLOT(timeout()));
}

FNMessageBox::FNMessageBox(const QString& caption, const QString& text, Icon icon, int button0, int button1, int button2, QWidget* parent, const char* name, bool modal, WFlags f) :  QMessageBox(caption, text, icon, button0, button1, button2, parent, name, modal, f)
{
	_timer = new QTimer(this);
	connect(_timer, SIGNAL(timeout()), this, SLOT(timeout()));
}

FNMessageBox::~FNMessageBox()
{
	delete _timer;
}

int FNMessageBox::information(QWidget* parent, const QString& caption, const QString& text, int button0, int button1, int button2)
{
	FNMessageBox dlg(caption, text, QMessageBox::Information, button0, button1, button2, parent);
	dlg.show();
	return dlg.exec();
}

int FNMessageBox::information(QWidget* parent, const QString& caption, const QString& text, const QString& button0Text, const QString& button1Text, const QString& button2Text, int defaultButtonNumber, int escapeButtonNumber)
{
	int button0 = 0;
	int button1 = 0;
	int button2 = 0;
	if (QString::null == button0Text) {
		int id = Ok;
		if (0 == defaultButtonNumber) {
			id += Default;
		}
		if (0 == escapeButtonNumber) {
			id += Escape;
		}
		button0 = id;
	}
	if (QString::null != button1Text) {
		int id = Cancel;
		if (1 == defaultButtonNumber) {
			id += Default;
		}
		if (1 == escapeButtonNumber) {
			id += Escape;
		}
		button1 = id;
	}
	if (QString::null != button2Text) {
		int id = Abort;
		if (2 == defaultButtonNumber) {
			id += Default;
		}
		if (2 == escapeButtonNumber) {
			id += Escape;
		}
		button2 = id;
	}
	FNMessageBox dlg(caption, text, QMessageBox::Information, button0, button1, button2, parent);
	if (0 != button0) {
		dlg.setButtonText(button0, button0Text);
	}
	if (0 != button1) {
		dlg.setButtonText(button1, button1Text);
	}
	if (0 != button2) {
		dlg.setButtonText(button2, button2Text);
	}
	dlg.show();
	return dlg.exec();
}

int FNMessageBox::warning(QWidget* parent, const QString& caption, const QString& text, int button0, int button1, int button2)
{
	FNMessageBox dlg(caption, text, QMessageBox::Warning, button0, button1, button2, parent);
	dlg.show();
	return dlg.exec();
}

int FNMessageBox::warning(QWidget* parent, const QString& caption, const QString& text, const QString& button0Text, const QString& button1Text, const QString& button2Text, int defaultButtonNumber, int escapeButtonNumber)
{
	int button0 = 0;
	int button1 = 0;
	int button2 = 0;
	if (QString::null == button0Text) {
		int id = Ok;
		if (0 == defaultButtonNumber) {
			id += Default;
		}
		if (0 == escapeButtonNumber) {
			id += Escape;
		}
		button0 = id;
	}
	if (QString::null != button1Text) {
		int id = Cancel;
		if (1 == defaultButtonNumber) {
			id += Default;
		}
		if (1 == escapeButtonNumber) {
			id += Escape;
		}
		button1 = id;
	}
	if (QString::null != button2Text) {
		int id = Abort;
		if (2 == defaultButtonNumber) {
			id += Default;
		}
		if (2 == escapeButtonNumber) {
			id += Escape;
		}
		button2 = id;
	}
	FNMessageBox dlg(caption, text, QMessageBox::Warning, button0, button1, button2, parent);
	if (0 != button0) {
		dlg.setButtonText(button0, button0Text);
	}
	if (0 != button1) {
		dlg.setButtonText(button1, button1Text);
	}
	if (0 != button2) {
		dlg.setButtonText(button2, button2Text);
	}
	dlg.show();
	return dlg.exec();
}

int FNMessageBox::critical(QWidget* parent, const QString& caption, const QString& text, int button0, int button1, int button2)
{
	FNMessageBox dlg(caption, text, QMessageBox::Critical, button0, button1, button2, parent);
	dlg.show();
	return dlg.exec();
}

int FNMessageBox::critical(QWidget* parent, const QString& caption, const QString& text, const QString& button0Text, const QString& button1Text, const QString& button2Text, int defaultButtonNumber, int escapeButtonNumber)
{
	int button0 = 0;
	int button1 = 0;
	int button2 = 0;
	if (QString::null == button0Text) {
		int id = Ok;
		if (0 == defaultButtonNumber) {
			id += Default;
		}
		if (0 == escapeButtonNumber) {
			id += Escape;
		}
		button0 = id;
	}
	if (QString::null != button1Text) {
		int id = Cancel;
		if (1 == defaultButtonNumber) {
			id += Default;
		}
		if (1 == escapeButtonNumber) {
			id += Escape;
		}
		button1 = id;
	}
	if (QString::null != button2Text) {
		int id = Abort;
		if (2 == defaultButtonNumber) {
			id += Default;
		}
		if (2 == escapeButtonNumber) {
			id += Escape;
		}
		button2 = id;
	}
	FNMessageBox dlg(caption, text, QMessageBox::Critical, button0, button1, button2, parent);
	if (0 != button0) {
		dlg.setButtonText(button0, button0Text);
	}
	if (0 != button1) {
		dlg.setButtonText(button1, button1Text);
	}
	if (0 != button2) {
		dlg.setButtonText(button2, button2Text);
	}
	dlg.show();
	return dlg.exec();
}

void FNMessageBox::about(QWidget* parent, const QString& caption, const QString& text)
{
	FNMessageBox dlg(caption, text, QMessageBox::NoIcon, 0, 0, 0, parent);
	dlg.show();
	dlg.exec();
}

void FNMessageBox::about(QWidget* parent, const QString& caption)
{
	FNMessageBox dlg(caption, QString::null, QMessageBox::NoIcon, 0, 0, 0, parent);
	dlg.show();
	dlg.exec();
}

void FNMessageBox::setTiming(const int v)
{
	___fnmessagebox_timing = v;
}

void FNMessageBox::timeout() {
	accept();
}

void FNMessageBox::showEvent(QShowEvent* ext)
{
	_timer->start(___fnmessagebox_timing, true);
}
