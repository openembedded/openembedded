/*  FreeNote for Sharp SLA300, B500, C7x0, C860 Linux PDA
	Copyright (C) 2003-2005 Joe Kanemori.<kanemori@ymg.urban.ne.jp>

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundatibannwaon; either version 2 of the License, or
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
2005/07/12 FreeNote 1.12.0
・Fixリリース

2005/06/04 FreeNote 1.11.12pre
・グリッドの枠線を実際の選択範囲よりも大きく表示するように変更。
・範囲選択、グリッド、ガイド、罫線カラーのカスタマイズを可能に。
・カラーピッカーモードの追加

2005/06/02 FreeNote 1.11.11Apre
・テキスト移動枠の不具合修正
・罫線をグリッドの２倍で表示するように変更
・消しゴム時の範囲指定時に、ペンオフしてワンテンポおいてから範囲確定するように変更

2005/03/18 FreeNote 1.11.10Bpre
・描画の最適化

2005/02/27 FreeNote 1.11.10pre
・PDFの出力形式を一部変更
・インポート時のバグfix

2005/01/04 FreeNote 1.11.6pre
・カーブモードで８の字がかけるように整形エンジンを改善

2005/01/04 FreeNote 1.11.5Apre
・バグフィックス

2004/12/25 FreeNote 1.11.5pre
・レイヤー機能追加

2004/10/17 FreeNote 1.10.0リリース
・ツール機能追2004/08/26 ver 1.9.3Apre
・罫線機能の修正

・ツール機能追2004/08/26 ver 1.9.3pre
・罫線機能を追加

2004/06/19-25 ver 1.9.2pre
・qcop装備

2004/05/19 ver 1.9.1pre
・PDFのテキストをUnicodeへ。
・オプションにPDF::Encode項目を追加。

2004/02/26 ver 1.9.0pre
・インポート機能
 
2004/02/19 ver 1.8.0 fix.
2004/02/16 ver 1.7.3pre
・編集機能強化

2004/02/14 ver 1.7.2pre
・検索機能追加

2004/02/12 ver 1.7.1pre
・フォント仕様の変更
・テキスト処理の高速化
・テキストボックスの多機能化

2004/02/10 ver 1.7.0pre
・文字入力

2003/12/21 ver 1.6.0
・フローティングパレットが無効となっていたバグを修正
・機能をＦｉｘ

2003/12/16-19 ver 1.5.5pre
・ペン幅の拡張(1-8)
・アンドゥ、リドゥの実装
・メニューの処理方法を一部改良
・高速Quit実装

2003/12/14 FreeNote 1.5.4pre
・ペンサイズを選択可能に。

2003/11/30-2003/12/04 FreeNote 1.5.3pre
・ExportPNG, ExportPDFの初期ファイル名がfreeファイル名に沿うように修正

2003/11/16 FreeNote 1.5.2pre
・曲線整形モード修正
　円描画のロジックを追加

2003/11/10-12 ver 1.5.1pre
・曲線整形モード追加

2003/11/09 ver 1.5.0pre
・自動整形モード追加

2003/09/03 ver 1.3.4pre
・Use all quadrant OFF時に表示位置がリセットされる場合があるバグ対応。

2003/09/01-03 ver 1.3.3pre
・スクロールの改良
・Use all quadrant(全象限を使用する)メニューを追加

2003/08/17-23 ver 1.3.0pre
・aboutを付与
・CRボタン追加
・スクロールモードの保存
・ガイド状態の保存

2003/08/17 FreeNote 1.2.2を公開
・拡張子.freeの自動付与が失敗するケースを修正

2003/08/15 FreeNote 1.2.1を公開
・保存時のバグ修正
・完了ダイアログの自動消去
・PNGファイルへの出力

2003/08/15 FreeNote 1.2を公開
・オプション追加
・スクロールガイド
・Freeファイル関連付け
・アイコンの変更

2003/08/05 FreeNote 1.1.1preを公開
・高速起動時に閉じた状態を保持
・描画モード切替え時に消しゴム表示
・保存時間短縮
・Viewモードの挙動を変更
・メニューの見た目を変更
*/
#include "frmmain.h"
#include <unistd.h>
#include <stdlib.h>

#include <qpe/global.h>
#include <qpe/qcopenvelope_qws.h>
#include <qpe/applnk.h>
#include <qpe/mimetype.h>

#include <qapplication.h>
#include <qtoolbutton.h>
#include <qmessagebox.h>
#include <qgrid.h>
#include <qdir.h>
#include <qstring.h>
#include <qdatetime.h>
#include <qtextcodec.h>
#include <qdatastream.h>
#include <qpixmap.h>

#include "fnfiledialog.h"
#include "fniconset.h"
#include "fmtengine.h"
#include "fnmessagebox.h"
#include "fnlayerdlg.h"
#include "fnpolygon.h"

#define VERSION "1.12.0"
/* 
 *  Constructs a FrmMain which is a child of 'parent', with the 
 *  name 'name' and widget flags set to 'f' 
 */
FrmMain::FrmMain( QWidget* parent,  const char* name, WFlags fl )
    : QMainWindow( parent, name, fl ),
    _drawMode(MODE_DRAW),
    _scrollMode(AS_BOTH),
    _useAllQuadrant(false),
    _showRuler(false),
    _isFullscreen(false),
    _isLocked(true),
    _isTinyPaging(false),
    _isTracking(true)
{
	connect( qApp, SIGNAL(appMessage( const QCString&, const QByteArray&)), this, SLOT( qcop_receive( const QCString&, const QByteArray& )));
	init();
	setup();
	setTitle();
}

void FrmMain::setup()
{
	_options.load();
	setOptions(_options);
}

void FrmMain::qcop_receive(const QCString& msg, const QByteArray& data)
{
	QDataStream stream(data, IO_ReadOnly );
	
	if (msg == "setPensize(int)") {
		int v;
		stream >> v;
		if (0 <= v && v <= 8) {
			penSelected(v);
		}
	} else if (msg == "setup()") {
		setup();
	} else if (msg == "modeChanged(int)") {
		int v;
		stream >> v;
		if (0 <= v && v <= MODE_MAX) {
			modeChanged(v);
		}
	} else if (msg == "changeColor(int,int,int)") {
		int r;
		int g;
		int b;
		stream >> r;
		stream >> g;
		stream >> b;
		if (0 <= r && r <= 255 &&
			0 <= g && g <= 255 &&
			0 <= b && b <= 255) 
		{
			changeColor(qRgb(r, g, b));
		}
	} else if (msg == "find()") {
		_canvas->find();
	} else if (msg == "undo()") {
		undo();
	} else if (msg == "redo()") {
		_canvas->redo();
	} else if (msg == "erase()") {
		_canvas->erase();
	} else if (msg == "copy()") {
		_canvas->copy();
	} else if (msg == "paste()") {
		_canvas->paste();
	} else if (msg == "clear()") {
		clear();
	} else if (msg == "CR()") {
		hitRet();
	} else if (msg == "setViewMode(int)") {
		int v;
		stream >> v;
		if (0 == v) {
			setViewMode(false);
		} else {
			setViewMode(true);
		}
	} else if (msg == "load(QString)") {
		QString fname;
		stream >> fname;
		_canvas->load(QFileInfo(fname));
	} else if (msg == "import(QString)") {
		QString fname;
		stream >> fname;
		_canvas->import(QFileInfo(fname));
	} else if (msg == "save(QString)") {
		QString fname;
		stream >> fname;
		_canvas->save(QFileInfo(fname));
	} else if (msg == "exportPDF(QString)") {
		QString fname;
		stream >> fname;
		_canvas->exportPDF(QFileInfo(fname));
	} else if (msg == "exportPNG(QString)") {
		QString fname;
		stream >> fname;
		QPixmap save(_canvas->wbuffer());
		_canvas->exportPNG(QFileInfo(fname), save);
	} else if (msg == "tool(int)") {
		int v;
		stream >> v;
		if (1 <= v && v <= 8) {
			tool(v);
		}
	}
}


//描画モードの変更
void FrmMain::modeChanged(int mode)
{
	_drawMode = mode;
	_btnCopy->setEnabled(false);
	//_btnPaste->setEnabled(false);
	_btnPaste->setEnabled(true);
	_btnRedo->setEnabled(true);
	_btnUndo->setEnabled(true);
	switch (_drawMode) {
	case MODE_DRAW: //描画
		_menubar->changeItem(_id_mode, QPixmap((const char**)draw_xpm));
		break;
	case MODE_FORMAT: //自動整形
		_menubar->changeItem(_id_mode, QPixmap((const char**)format_xpm));
		break;
	case MODE_CURVE: //曲線整形
		_menubar->changeItem(_id_mode, QPixmap((const char**)curve_xpm));
		break;
	case MODE_SMOOTH: //スムージング
		_menubar->changeItem(_id_mode, QPixmap((const char**)smooth_xpm));
		break;
	case MODE_TEXT: //テキスト
		_menubar->changeItem(_id_mode, QPixmap((const char**)text_xpm));
		break;
	case MODE_ERASE: //編集モード
		_btnCopy->setEnabled(true);
		_btnRedo->setEnabled(false);
		_menubar->changeItem(_id_mode, QPixmap((const char**)eraser_xpm));
		break;
	case MODE_CPICK:
		_menubar->changeItem(_id_mode, QPixmap((const char**)cpick_xpm));
		break;
	}
	_canvas->modeChanged(_drawMode);
}

//描画モードの切り替え
void FrmMain::modeMenuChanged(int id)
{
	modeChanged(_draw_menu->indexOf(id));
}

void FrmMain::tool(int id)
{
	QString home = getenv("HOME");
	QString cmd = _options.toolScripts[id];
	if (cmd == "") {
		return;
	}
	QStringList token = QStringList::split(' ', cmd);
	QDateTime dtime = QDateTime::currentDateTime();
	QDate dt = dtime.date();
	QTime tm = dtime.time();
	char buf[32];
	sprintf(buf, "%02d%02d%02d%02d%02d%02d", dt.year() % 100, dt.month(), dt.day(), tm.hour(), tm.minute(), tm.second());
	QString wkdir = _options.wkdir;
	if (false == QFileInfo(wkdir).isDir()) {
		wkdir = home;
	}
	int st = 0;
	for (uint i = st; i < token.count(); ++i) {
		if (token[i] == "%file") {
			save();
			if (_prefile == "") {
				return;
			}
			token[i] = _prefile;
		} else if (token[i] == "%pdf") {
			exportPDF();
			if (_prepdf == "") {
				return;
			}
			token[i] = _prepdf;
		} else if (token[i] == "%png") {
			exportPNG();
			if (_prepng == "") {
				return;
			}
			token[i] = _prepng;
		} else if (token[i] == "%tmpfile") {
			_canvas->save(QFileInfo(home + "/.tmp.free"));
			token[i] = home + "/.tmp.free";
		} else if (token[i] == "%tmppng") {
			QPixmap save(_canvas->wbuffer());
			_canvas->exportPNG(QFileInfo(home + "/.tmp.png"), save);
			token[i] = home + "/.tmp.png";
		} else if (token[i] == "%tmppdf") {
			_canvas->exportPDF(QFileInfo(home + "/.tmp.pdf"));
			token[i] = home + "/.tmp.pdf";
		} else if (token[i] == "%newfile") {
			token[i] = wkdir + "/" + buf +".free";
			_canvas->save(QFileInfo(token[i]));
		} else if (token[i] == "%newpng") {
			QPixmap save(_canvas->wbuffer());
			token[i] = wkdir + "/" + buf +".png";
			_canvas->exportPNG(QFileInfo(token[i]), save);
		} else if (token[i] == "%newpdf") {
			token[i] = wkdir + "/" + buf +".pdf";
			_canvas->exportPDF(QFileInfo(token[i]));
		}
	}

	QFileInfo exefile(token[0]);
	if (exefile.extension() == "desktop") {
		const AppLnk *app= new AppLnk(exefile.absFilePath());
		QStringList args;
		for (uint i = 1; i < token.count(); ++i) {
			args << token[i];
		}
		app->execute(args);
		delete app;
		showMinimized();
	} else if (token[0] == "qcop") {
		if (3 <= token.count()) {
			QCopEnvelope qcop((const char*)token[1], (const char*)token[2]);
			for (uint i = 3; i < token.count(); ++i) {
				qcop << token[i];
			}
		}
	} else {
		QString args = token[0];
		for (uint i = 1; i < token.count(); ++i) {
			args += " ";
			args += token[i];
		}
		//Global::invoke(args);
		Global::execute(args);
	}
}

//オプションの設定
void FrmMain::setOptions(const FNOptionData& o)
{
	_tool_menu->changeItem(_id_tool1, "1:" + o.toolNames[0]);
	_tool_menu->changeItem(_id_tool2, "2:" + o.toolNames[1]);
	_tool_menu->changeItem(_id_tool3, "3:" + o.toolNames[2]);
	_tool_menu->changeItem(_id_tool4, "4:" + o.toolNames[3]);
	_tool_menu->changeItem(_id_tool5, "5:" + o.toolNames[4]);
	_tool_menu->changeItem(_id_tool6, "6:" + o.toolNames[5]);
	_tool_menu->changeItem(_id_tool7, "7:" + o.toolNames[6]);
	_tool_menu->changeItem(_id_tool8, "8:" + o.toolNames[7]);

	_canvas->setScrollTiming(o.timing);
	_canvas->setVStep(o.v_step);
	_canvas->setHStep(o.h_step);
	_canvas->setSEraser(o.eraser_s);
	_canvas->setLEraser(o.eraser_l);
	_canvas->setMargin(o.margin);
	
	_vscb->setPageStep(o.v_step);
	_vscb->setLineStep(o.grid_size * 2);
	_hscb->setPageStep(o.h_step);
	_hscb->setLineStep(o.grid_size * 2); 

	SNAP_SIZE = o.grid_size;
	PHASE1_ANGLE = o.phase1;
	PHASE2_ANGLE = o.phase2;

	if (o.isLMvAOn) {
		_btnLMvA->show();
	} else {
		_btnLMvA->hide();
	}
	if (o.isLMvBOn) {
		_btnLMvB->show();
	} else {
		_btnLMvB->hide();
	}
	if (o.isLAddOn) {
		_btnLAdd->show();
	} else {
		_btnLAdd->hide();
	}
	if (o.isFindOn) {
		_btnFind->show();
	} else {
		_btnFind->hide();
	}

	if (o.isMaximizedOn) {
		_btnMaximized->show();
	} else {
		_btnMaximized->hide();
	}

	if (o.isCopyOn) {
		_btnCopy->show();
	} else {
		_btnCopy->hide();
	}

	if (o.isPasteOn) {
		_btnPaste->show();
	} else {
		_btnPaste->hide();
	}

	if (o.isImportOn) {
		_btnImport->show();
	} else {
		_btnImport->hide();
	}

	if (o.isUndoOn) {
		_btnUndo->show();
	} else {
		_btnUndo->hide();
	}

	if (o.isRedoOn) {
		_btnRedo->show();
	} else {
		_btnRedo->hide();
	}

	if (o.isZoomOn) {
		_btnZoom->show();
	} else {
		_btnZoom->hide();
	}

	if (o.isCROn) {
		_btnRet->show();
	} else {
		_btnRet->hide();
	}

	if (o.isGuideOn) {
		_btnGuide->show();
	} else {
		_btnGuide->hide();
	}

	if (o.isNewOn) {
		_btnNew->show();
	} else {
		_btnNew->hide();
	}

	if (o.isClearOn) {
		_btnClear->show();
	} else {
		_btnClear->hide();
	}

	if (o.isOpenOn) {
		_btnLoad->show();
	} else {
		_btnLoad->hide();
	}

	if (o.isSaveOn) {
		_btnSave->show();
	} else {
		_btnSave->hide();
	}

	if (o.isExportOn) {
		_btnExportPDF->show();
	} else {
		_btnExportPDF->hide();
	}

	if (o.isExportPNGOn) {
		_btnExportPNG->show();
	} else {
		_btnExportPNG->hide();
	}

	if (o.isLayerOn) {
		_btnLayer->show();
	} else {
		_btnLayer->hide();
	}

	if (AS_HORIZONTAL == o.scrollMode) {
		_as_horz->setOn(true);
	} else if (AS_VERTICAL == o.scrollMode) {
		_as_vert->setOn(true);
	} else if (AS_BOTH == o.scrollMode) {
		_as_both->setOn(true);
	}
	_btnGuide->setOn(o.isAutoScrollEnabled);
	this->showGuide(o.isAutoScrollEnabled);
	_canvas->setShowRuler(_showRuler = o.isShowRuler);
	_canvas->setUseAllQuadrant(_useAllQuadrant = o.useAllQuadrant);
	_scroll_menu->setItemChecked(_id_quadrant, _useAllQuadrant);
	if (_useAllQuadrant) {
		_vscb->setMinValue(-200);
		_hscb->setMinValue(-200);
	} else {
		_vscb->setMinValue(0);
		_hscb->setMinValue(0);
	}
	_scroll_menu->setItemChecked(_id_ruler, _showRuler);
	_canvas->setEncode(o.encode);
	_canvas->setFontName(o.fontname);
	_canvas->setColorRevision(o.isColorRevision);
	_canvas->setTxtBoxRect(o.txtBoxRect);
	SelectionLineColor = o.selectionLineColor;
	SelectionBrushColor = o.selectionBrushColor;
	SelectionFrameColor = o.selectionFrameColor;
	RulerColor = o.rulerColor;
	GuideColor = o.guideColor;
	GridColor = o.gridColor;
	
	_canvas->redraw();
}

//罫線を表示する（トグル）
void FrmMain::showRuler()
{
	_showRuler = !_showRuler;
	_canvas->setShowRuler(_showRuler);
	_options.isShowRuler = _showRuler;
	_scroll_menu->setItemChecked(_id_ruler, _showRuler);
	_options.save();
}

//全象限を使用する（トグル）
void FrmMain::useAllQuadrant()
{
	_useAllQuadrant = !_useAllQuadrant;
	if (_useAllQuadrant) {
		_vscb->setMinValue(-200);
		_hscb->setMinValue(-200);
	} else {
		_vscb->setMinValue(0);
		_hscb->setMinValue(0);
	}
	_canvas->setUseAllQuadrant(_useAllQuadrant);
	_scroll_menu->setItemChecked(_id_quadrant, _useAllQuadrant);
	_options.useAllQuadrant = _useAllQuadrant;
	_options.save();
}

//ファイルを渡してオープン
void FrmMain::setDocument(const QString& fname)
{
	this->open(fname);
}

void FrmMain::showFullScreen()
{
	showNormal();
	_isFullscreen = true;
	QMainWindow::showFullScreen();
}

void FrmMain::changeColor(QRgb c)
{
	_btnColor->setBGColor(c);
	_canvas->changeColor(c);
}

//ビューモードの切り替え
void FrmMain::setViewMode(bool flg)
{
	if (MODE_ERASE == _drawMode) {
		if (flg) {
			_btnCopy->setEnabled(false);
			_btnPaste->setEnabled(false);
			_btnUndo->setEnabled(false);
			_btnRedo->setEnabled(false);
		} else {
			_btnCopy->setEnabled(true);
			_btnPaste->setEnabled(true);
			_btnUndo->setEnabled(true);
		}
	} else {
		_btnCopy->setEnabled(false);
		_btnPaste->setEnabled(true);
		_btnUndo->setEnabled(true);
		_btnRedo->setEnabled(true);
	}
	_canvas->viewChanged(flg);
	_vscb->setEnabled(!flg);
	_hscb->setEnabled(!flg);
}

//初期設定
void FrmMain::init()
{
	_colorSelector = new FNColorDialog(this);
    QGrid* grid = new QGrid(2, this);
	_canvas = new FNCanvas(_colorSelector, grid);
	_canvas->resize(240, 320);
	_vscb = new QScrollBar(0, 960, 10, 100, 0, Qt::Vertical, grid);
	_hscb = new QScrollBar(0, 960, 10, 100, 0, Qt::Horizontal, grid);
    this->setCentralWidget(grid);
    this->setToolBarsMovable(false);
	connect(_vscb, SIGNAL(valueChanged(int)), this, SLOT(scroll()));
	connect(_hscb, SIGNAL(valueChanged(int)), this, SLOT(scroll()));
	connect(_canvas, SIGNAL(originChanged(int, int)), this, SLOT( scrollbarChange(int, int)));
	//メニューの構築
	bool isVGA = false;
	if (320 < QApplication::desktop()->width()) {
		isVGA = true;
	}

	_page_tool = new QPEToolBar(this);
    _page_tool->setHorizontalStretchable(true);
    
	_btnColor = new FNColorPalette(black, _page_tool);
	_chkFill = new QCheckBox(_page_tool);
	_chkFill->setText("F");
	_chkFill->setFocusPolicy(NoFocus);
	_page_tool->addSeparator();
	if (isVGA) {
		_btnColor->setMinimumSize(48, 32);
		_btnColor->setMaximumSize(48, 32);
	} else {
		_btnColor->setMinimumSize(24, 18);
		_btnColor->setMaximumSize(24, 18);
	}
	_btnLMvA = newToolButton(_page_tool, (const char**)movetoabove_xpm, "move to above layer", isVGA);
	_btnLMvB = newToolButton(_page_tool, (const char**)movetobelow_xpm, "move to below layer", isVGA);
	_btnLAdd = newToolButton(_page_tool, (const char**)addlayer_xpm, "add new layer", isVGA);
    _btnFind = newToolButton(_page_tool, (const char**)find_xpm, "find", isVGA);
	_btnMaximized = newToolButton(_page_tool, (const char **)maximized_xpm, "maximized", isVGA);
	_btnCopy = newToolButton(_page_tool, (const char**)copy_xpm, "copy", isVGA);
	_btnPaste = newToolButton(_page_tool, (const char**)paste_xpm, "paste", isVGA);
	_btnImport = newToolButton(_page_tool, (const char**)import_xpm, "import", isVGA);
	_btnUndo = newToolButton(_page_tool, (const char**)undo_xpm, "undo", isVGA);
	_btnRedo = newToolButton(_page_tool, (const char**)redo_xpm, "redo", isVGA);
	//_btnColor = newToolButton(_page_tool, (const char **)color_xpm, "select color", isVGA);
	
	_btnZoom = newToolButton(_page_tool, (const char **)zoom_xpm, "zoom", isVGA, true, false, 48);
	_btnRet = newToolButton(_page_tool, (const char**)ret_xpm, "return", isVGA);
	_btnGuide = newToolButton(_page_tool, (const char **)guide_xpm, "scroll guide", isVGA, true);
	_btnNew = newToolButton(_page_tool, (const char **)new_xpm, "new page", isVGA);
	_btnClear = newToolButton(_page_tool, (const char **)clear_xpm, "clear page", isVGA);
	_btnLoad = newToolButton(_page_tool, (const char **)open_xpm, "load page", isVGA);
	_btnSave = newToolButton(_page_tool, (const char **)save_xpm, "save page", isVGA);
	_btnExportPDF = newToolButton(_page_tool, (const char **)pdf_xpm, "export PDF", isVGA);
	_btnExportPNG = newToolButton(_page_tool, (const char **)png_xpm, "export PNG", isVGA);
	_btnLayer = newToolButton(_page_tool, (const char**)layer_xpm, "layer on", isVGA);

	connect(_btnLMvA, SIGNAL(clicked()), this, SLOT(moveAboveLayer()));
	connect(_btnLMvB, SIGNAL(clicked()), this, SLOT(moveBelowLayer()));
	connect(_btnLAdd, SIGNAL(clicked()), this, SLOT(addLayer()));
	connect(_btnFind, SIGNAL(clicked()), _canvas, SLOT(find()));
	connect(_btnColor, SIGNAL(clicked(FNPaletteBase*)), this, SLOT(colorSelectorPopup()));
	
	connect(_btnRet, SIGNAL(clicked()), this, SLOT(hitRet()));
	connect(_btnSave, SIGNAL(clicked()), this, SLOT(save()));
	connect(_btnLoad, SIGNAL(clicked()), this, SLOT(load()));
	connect(_btnNew, SIGNAL(clicked()), this, SLOT(newPage()));
	connect(_btnClear, SIGNAL(clicked()), this, SLOT(clear()));
	connect(_btnExportPDF, SIGNAL(clicked()), this, SLOT(exportPDF()));
	connect(_btnExportPNG, SIGNAL(clicked()), this, SLOT(exportPNG()));
	connect(_btnLayer, SIGNAL(clicked()), this, SLOT(showLayer()));

	connect(_btnMaximized, SIGNAL(clicked()), this, SLOT(showFullScreen()));
	connect(_btnZoom, SIGNAL(toggled(bool)), this, SLOT(setViewMode(bool)));
	connect(_btnCopy, SIGNAL(clicked()),  _canvas, SLOT(copy()));
	connect(_btnPaste, SIGNAL(clicked()),  _canvas, SLOT(paste()));
	connect(_btnImport, SIGNAL(clicked()),  this, SLOT(import()));
	connect(_btnUndo, SIGNAL(clicked()),  this, SLOT(undo()));
	connect(_btnRedo, SIGNAL(clicked()),  _canvas, SLOT(redo()));
	connect(_btnGuide, SIGNAL(toggled(bool)), this, SLOT(showGuide(bool)));
	connect(_canvas, SIGNAL(resetViewMode()), _btnZoom, SLOT(toggle()));
	connect(_chkFill, SIGNAL(toggled(bool)), _canvas, SLOT(fillChanged(bool)));
	connect(_canvas, SIGNAL(pickColor(QRgb)), this, SLOT(changeColor(QRgb)));

	_scroll_menu = new QPopupMenu();
	QActionGroup* scroll_action_group = new QActionGroup(_scroll_menu, "scroll actions", true);
	scroll_action_group->insert(_as_horz = new QAction("horz", "&Horizontal", 0, scroll_action_group, 0, true));
	scroll_action_group->insert(_as_vert = new QAction("vert", "&Vertical", 0, scroll_action_group, 0, true));
	scroll_action_group->insert(_as_both = new QAction("both", "&Both", 0, scroll_action_group, 0, true));
	_as_both->setOn(true);
    _id_guide = _scroll_menu->insertItem("&Guide", _btnGuide, SLOT(toggle()), CTRL + Key_G);
	_id_ruler = _scroll_menu->insertItem("show &Ruler", this, SLOT(showRuler()), CTRL + Key_K);
	_id_quadrant = _scroll_menu->insertItem("&Use all quadrant", this, SLOT(useAllQuadrant()), CTRL + Key_U);
	_scroll_menu->insertSeparator();
	scroll_action_group->addTo(_scroll_menu);
	connect(scroll_action_group, SIGNAL(selected(QAction*)), this, SLOT(scroll_menu_selected(QAction*)));

	_main_menu = new QPopupMenu();
	_main_menu->setCheckable(true);

	_edit_menu = new QPopupMenu();
    _edit_menu->insertItem("&Copy", _canvas, SLOT(copy()), CTRL + Key_C);
    _edit_menu->insertItem("&Paste", _canvas, SLOT(paste()), CTRL + Key_V);
    _edit_menu->insertItem("&Undo", this, SLOT(undo()), CTRL + Key_Z);
    _edit_menu->insertItem("&Redo", _canvas, SLOT(redo()), CTRL + Key_Y);
    _edit_menu->insertItem("&Find", _canvas, SLOT(find()), CTRL + Key_F);
    
    _main_menu->insertItem("&Edit", _edit_menu);

    _layer_menu = new QPopupMenu();
    _layer_menu->insertItem("show", this, SLOT(showLayer()), CTRL + Key_B);
    _layer_menu->insertItem("move above", this, SLOT(moveAboveLayer()), Key_A);
    _layer_menu->insertItem("move below", this, SLOT(moveBelowLayer()), Key_Z);
    _layer_menu->insertItem("add layer", this, SLOT(addLayer()), CTRL + Key_A);
	_id_tinyPaging = _layer_menu->insertItem("tiny paging mode", this, SLOT(toggleTinyPaging()), CTRL + Key_T);
    _main_menu->insertItem("&Layer", _layer_menu);


    _tool_menu = new QPopupMenu();
    _id_tool1 = _tool_menu->insertItem("1:", this, SLOT(tool1()), CTRL + Key_1);
    _id_tool2 = _tool_menu->insertItem("2:", this, SLOT(tool2()), CTRL + Key_2);
    _id_tool3 = _tool_menu->insertItem("3:", this, SLOT(tool3()), CTRL + Key_3);
    _id_tool4 = _tool_menu->insertItem("4:", this, SLOT(tool4()), CTRL + Key_4);
    _id_tool5 = _tool_menu->insertItem("5:", this, SLOT(tool5()), CTRL + Key_5);
    _id_tool6 = _tool_menu->insertItem("6:", this, SLOT(tool6()), CTRL + Key_6);
    _id_tool7 = _tool_menu->insertItem("7:", this, SLOT(tool7()), CTRL + Key_7);
    _id_tool8 = _tool_menu->insertItem("8:", this, SLOT(tool8()), CTRL + Key_8);
    _main_menu->insertItem("&Tool", _tool_menu);

    _main_menu->insertItem("&Zoom", _btnZoom, SLOT(toggle()), Key_Tab);
    _main_menu->insertItem("&Maximize", this, SLOT(showFullScreen()), CTRL + Key_M);
    _main_menu->insertItem("&Normalize", this, SLOT(showNormal()), CTRL + Key_R);
    _main_menu->insertSeparator();
    
    _main_menu->insertItem("&Scroll", _scroll_menu);
    _main_menu->insertSeparator();

    _file_menu = new QPopupMenu();
	_file_menu->setCheckable(true);
    _file_menu->insertItem("&New", this, SLOT(newPage()), CTRL + Key_N);
    _file_menu->insertItem("&Clear", this, SLOT(clear()), CTRL + Key_L);
    _file_menu->insertItem("&Import", this, SLOT(import()), CTRL + Key_I);
    _file_menu->insertItem("&Load", this, SLOT(load()), CTRL + Key_O);
    _file_menu->insertItem("&Save", this, SLOT(save()), CTRL + Key_S);
    _file_menu->insertItem("save &As", this, SLOT(saveAs()));
    _main_menu->insertItem("&File", _file_menu);
    
    _export_menu = new QPopupMenu();
    _export_menu->setCheckable(true);
    _export_menu->insertItem("PDF", this, SLOT(exportPDF()), CTRL + Key_P);
    _export_menu->insertItem("PNG", this, SLOT(exportPNG()), CTRL + Key_E);
    _export_menu->insertSeparator();
	_id_saveNPdf = _export_menu->insertItem("save with pdf", this, SLOT(toggleSaveNPdf()));

    _main_menu->insertItem("&Export", _export_menu);
    _main_menu->insertSeparator();
    _main_menu->insertItem("&Quit", this, SLOT(quit()), Key_Escape);
    _main_menu->insertSeparator();
    _main_menu->insertItem("&About", this, SLOT(about()));

    _menubar = new QPEMenuBar(this);
	_menubar->insertItem("&Menu", _main_menu);

    _draw_menu = new QPopupMenu();
    int id_draw;
    id_draw = _draw_menu->insertItem(QIconSet(QPixmap((const char**)draw_xpm)), "&Draw");
    _draw_menu->setAccel(Key_D, id_draw);
    id_draw = _draw_menu->insertItem(QIconSet(QPixmap((const char**)format_xpm)), "Auto&Format");
    _draw_menu->setAccel(Key_F, id_draw);
    id_draw = _draw_menu->insertItem(QIconSet(QPixmap((const char**)curve_xpm)), "Auto&Curve");
    _draw_menu->setAccel(Key_C, id_draw);
    id_draw = _draw_menu->insertItem(QIconSet(QPixmap((const char**)smooth_xpm)), "&Smooth");
    _draw_menu->setAccel(Key_S, id_draw);
    id_draw = _draw_menu->insertItem(QIconSet(QPixmap((const char**)text_xpm)), "&Text");
    _draw_menu->setAccel(Key_T, id_draw);
    id_draw = _draw_menu->insertItem(QIconSet(QPixmap((const char**)eraser_xpm)), "&Eraser");
    _draw_menu->setAccel(Key_E, id_draw);
    id_draw = _draw_menu->insertItem(QIconSet(QPixmap((const char**)cpick_xpm)), "Color&Picker");
    _draw_menu->setAccel(Key_P, id_draw);
    _id_mode = _menubar->insertItem(QPixmap((const char**)draw_xpm), _draw_menu);
	connect(_draw_menu, SIGNAL(activated(int)), this, SLOT(modeMenuChanged(int)));
	connect(_canvas, SIGNAL(changeMode(int)), this, SLOT(modeChanged(int)));
	
	_pen_menu = new QPopupMenu();
	for (int i = 0; i < 8; ++i) {
		char buf[5];
		sprintf(buf, "%dpts.", (i + 1));
		int id = _pen_menu->insertItem(QIconSet(makePenPixmap(i + 1)), buf);
		_pen_menu->setAccel(Key_1 + i, id);
	}
	_id_pen = _menubar->insertItem(makePenPixmap(1), _pen_menu);
	connect(_pen_menu, SIGNAL(activated(int)), this, SLOT(penSelected(int)));
	_menubar->insertItem(_page_tool);
	_btnCopy->setEnabled(false);
	_btnPaste->setEnabled(true);
	_title = "";
}

void FrmMain::undo()
{
	_canvas->undo();
	setTitle();
}

void FrmMain::addLayer()
{
	_canvas->addLayer();
	setTitle();
}

void FrmMain::moveAboveLayer()
{
	_canvas->moveAboveLayer();
	setTitle();
}

void FrmMain::moveBelowLayer()
{
	_canvas->moveBelowLayer();
	setTitle();
}

//簡易ページモードを切り替える
void FrmMain::toggleTinyPaging()
{
	bool f = _canvas->isTinyPaging();
	_canvas->setTinyPaging(!f);
	setTitle();
}


//ペン画像の作成
QPixmap FrmMain::makePenPixmap(int n)
{
	const char** icons[] = {
		(const char**)pt1_xpm,
		(const char**)pt2_xpm,
		(const char**)pt3_xpm,
		(const char**)pt4_xpm,
		(const char**)pt5_xpm,
		(const char**)pt6_xpm,
		(const char**)pt7_xpm,
		(const char**)pt8_xpm,
	};
    QPixmap pt(icons[n - 1]);
    QImage mask = pt.mask()->convertToImage();
    pt = pt.convertToImage().smoothScale(32/*48*/, 16);
    QBitmap msk;
    msk = mask.smoothScale(32/*48*/, 16);
    pt.setMask(msk);
	return pt;
}

//ペンの選択
void FrmMain::penSelected(int id)
{
	int idx = _pen_menu->indexOf(id);
	if (-1 != idx) {
		_menubar->changeItem(_id_pen, makePenPixmap(idx + 1));
		_canvas->setPensize(idx + 1);
	}
}

//Save with PDFの切り替え
void FrmMain::toggleSaveNPdf()
{
	if (_export_menu->isItemChecked(_id_saveNPdf)) {
		_export_menu->setItemChecked(_id_saveNPdf, false);
	} else {
		_export_menu->setItemChecked(_id_saveNPdf, true);
	}
}

//ツールボタンの作成
QToolButton* FrmMain::newToolButton(QWidget* parent, const char** icon1, const char** icon2, const QString& textLabel,  const bool isVGA, const bool isToggle, const bool isOn, const int width)
{
	QToolButton* btn = new QToolButton(parent);
	if (isVGA) {
		btn->setMinimumSize(width, 32);
		btn->setMaximumSize(width, 32);
	} else {
		btn->setMinimumSize(18, 18);
		btn->setMaximumSize(18, 18);
	}
	btn->setOnIconSet(QIconSet(QPixmap(icon1)));
	btn->setOffIconSet(QIconSet(QPixmap(icon2)));
	btn->setToggleButton(isToggle);
	btn->setOn(isOn);
	btn->setTextLabel(textLabel);
	btn->setAutoRaise(false);

	return btn;
}

//ツールボタンの作成
QToolButton* FrmMain::newToolButton(QWidget* parent, const char** icon, const QString& textLabel,  const bool isVGA, const bool isToggle, const bool isOn, const int width)
{
	QToolButton* btn = new QToolButton(parent);
	if (isVGA) {
		btn->setMinimumSize(width, 32);
		btn->setMaximumSize(width, 32);
	} else {
		btn->setMinimumSize(20, 20);
		btn->setMaximumSize(20, 20);
	}
	btn->setPixmap(QPixmap(icon));
	btn->setToggleButton(isToggle);
	btn->setOn(isOn);
	btn->setTextLabel(textLabel);
	btn->setAutoRaise(false);

	return btn;
}

//スクロールメニューの選択
void FrmMain::scroll_menu_selected(QAction* act)
{
	if (act->text() == "horz") {
		_options.scrollMode = _scrollMode = AS_HORIZONTAL;
	} else if (act->text() == "vert") {
		_options.scrollMode = _scrollMode = AS_VERTICAL;
	} else if (act->text() == "both") {
		_options.scrollMode = _scrollMode = AS_BOTH;
	}
	_options.save();
	if (_btnGuide->isOn()) {
		_canvas->setScrollMode(_scrollMode);
	}
}

//ガイドの表示
void FrmMain::showGuide(bool flg)
{
	_canvas->setGuide(flg);
	if (flg) {
		_canvas->setScrollMode(_scrollMode);
	} else {
		_canvas->setScrollMode(AS_NONE);
	}
	_main_menu->setItemChecked(_id_guide, flg);
	if (flg != _options.isAutoScrollEnabled) {
		_options.isAutoScrollEnabled = flg;
		_options.save();
	}
}

//スクロールバーの設定
void FrmMain::scrollbarChange(int x, int y)
{
	//*
	if (_useAllQuadrant) {
		if (-200 != _vscb->minValue()) {
			_vscb->setMinValue(-200);
		}
		if (-200 != _hscb->minValue()) {
			_hscb->setMinValue(-200);
		}
	} else {
		if (0 != _vscb->minValue()) {
			_vscb->setMinValue(0);
		}
		if (0 != _hscb->minValue()) {
			_hscb->setMinValue(0);
		}
	}
	//*/
	if (_canvas->isShowGuide()) {
		_isTracking = false;
	} else {
		_isTracking = false;
	}
	_hscb->setValue(x);
	_vscb->setValue(y);
}

//新規ページ作成
void FrmMain::newPage()
{
	if (QMessageBox::warning( this, "FreeNote Qt", "OK to create new page ?", "OK", "Cancel", 0, 1, 1 )) {
		return;
	}
	_hscb->setMaxValue(960);
	_vscb->setMaxValue(960);
	_canvas->clear();
	QDir dir = _file.dir();
	_file.setFile(dir, "");
	_title = "";
	setTitle();
}

//ページクリア
void FrmMain::clear()
{
	if (QMessageBox::warning( this, "FreeNote Qt", "OK to clear this page ?", "OK", "Cancel", 0, 1, 1 )) {
		return;
	}
	_hscb->setMaxValue(960);
	_vscb->setMaxValue(960);
	_canvas->clear();
}

//カラーセレクタの表示
void FrmMain::colorSelectorPopup() 
{
	_colorSelector->setColor(_btnColor->color());
	_colorSelector->show();
	if (_colorSelector->exec()) {
		changeColor(_colorSelector->color().rgb());
	}
}

//ファイルオープン
void FrmMain::open(const QString& fname)
{
	_file.setFile(fname);
	if (_file.exists()) {
		_canvas->load(_file.absFilePath());
		setTitle(&_file);
	} else {
		_file.setFile(_file.dir(), "");
	}
}

//ファイル保存
void FrmMain::save()
{
	_prefile = "";
	if (!_file.exists() || _file.isDir() || _file.extension(false) != "free") {
		return saveAs();
	} else {
		Config conf("FreeNoteQt");
		conf.setGroup("Format");
		_file.setFile(QDir(conf.readEntry("free", _file.dirPath())), _file.fileName());
		_canvas->save(_file.absFilePath());
		_prefile = _file.absFilePath();
		conf.writeEntry("free", _file.dirPath() + "/");
		setTitle(&_file);
		if (_export_menu->isItemChecked(_id_saveNPdf)) {
			QFileInfo info = _file;
			QString tmpf = _file.absFilePath();
			tmpf = tmpf.left(tmpf.findRev(".free"));
			info.setFile(tmpf + ".pdf");
			_canvas->exportPDF(info);
		}
	}
}

//別名保存
void FrmMain::saveAs()
{
	_prefile = "";
	Config conf("FreeNoteQt");
	conf.setGroup("Format");
	if (_file.baseName() == "") {
		_file.setFile(QDir(conf.readEntry("free", _file.dirPath())), "");
	} else {
		_file.setFile(QDir(conf.readEntry("free", _file.dirPath())), _file.fileName());
	}

	//_frmPalette->close();
	FNFileDialog dlg(this, "*.free", "FreeNote Qt - save", false);
	dlg.setCurrentFile(_file);
	dlg.showMaximized();
	if (dlg.exec()) {
		QFileInfo info = dlg.currentFile();
		if (!info.isDir() && !dlg.isTopDir()) {
			if (info.extension(false) != "free") {
				QDir dir = info.dir(true);
				QString fname = info.fileName();
				info.setFile(dir, fname + ".free");
			}
			if (info.exists()) {
				if (QMessageBox::warning( this, "FreeNote Qt", "file " + info.fileName() + "\n already exists.\n\n OK to overwrite ?", "OK", "Cancel", 0, 1, 1 )) {
					return;
				}
			}
			_file = info;
			if (_canvas->save(_file)) {
				_prefile = _file.absFilePath();
				conf.writeEntry("free", _file.dirPath() + "/");
				setTitle(&_file);
				if (_export_menu->isItemChecked(_id_saveNPdf)) {
					QString tmpf = _file.absFilePath();
					tmpf = tmpf.left(tmpf.findRev(".free"));
					info.setFile(tmpf + ".pdf");
					_canvas->exportPDF(info);
				}
			}
		}
	}
}

//ファイル読み込み
void FrmMain::load()
{
	Config conf("FreeNoteQt");
	conf.setGroup("Format");
	if (_file.fileName() == "") {
		_file.setFile(QDir(conf.readEntry("free", _file.dirPath())), ".free");
	} else {
		_file.setFile(QDir(conf.readEntry("free", _file.dirPath())), _file.fileName());
	}

	//_frmPalette->close();
	FNFileDialog dlg(this, "*.free", "FreeNote Qt - load", true);
	dlg.setCurrentFile(_file);
	dlg.showMaximized();
	if (dlg.exec()) {
		QFileInfo info = dlg.currentFile();
		if (info.isFile() && info.exists()) {
			_file = info;
			if (_canvas->load(_file)) {
				_prefile = _file.absFilePath();
				conf.writeEntry("free", _file.dirPath() + "/");
				setTitle(&_file);
			}
		}
	}
}

//クリップボード読み込み
void FrmMain::import()
{
	Config conf("FreeNoteQt");
	conf.setGroup("Format");
	QFileInfo info = _file;
	if (info.fileName() == "") {
		info.setFile(QDir(conf.readEntry("import", info.dirPath())), ".free");
	} else {
		info.setFile(QDir(conf.readEntry("import", info.dirPath())), info.fileName());
	}

	//_frmPalette->close();
	FNFileDialog dlg(this, "*.free", "FreeNote Qt - import", true);
	dlg.setCurrentFile(info);
	dlg.showMaximized();
	if (dlg.exec()) {
		info = dlg.currentFile();
		if (info.isFile() && info.exists()) {
			_canvas->import(info);
			conf.writeEntry("import", info.dirPath() + "/");
		}
	}
}

//PNGへの出力
void FrmMain::exportPNG()
{
	_prepng = "";
	Config conf("FreeNoteQt");
	conf.setGroup("Format");
	QFileInfo info = _file;
	if (info.fileName() == "") {
		info.setFile(QDir(conf.readEntry("png", info.dirPath())), "");
	} else {
		info.setFile(QDir(conf.readEntry("png", info.dirPath())), info.fileName());
	}

	//_frmPalette->close();
	QPixmap save(_canvas->wbuffer());
	FNFileDialog dlg(this, "*.png", "FreeNote Qt - exportPNG", false);
	if (info.extension()=="free") {
		QString tmpf = info.absFilePath();
		tmpf = tmpf.left(tmpf.findRev(".free"));
		info.setFile(tmpf);
	} else {
		info.setFile(info.dir(), "");
	}
	dlg.setCurrentFile(info);
	dlg.showMaximized();
	if (dlg.exec() && !dlg.isTopDir()) {
		info = dlg.currentFile();
		if (!info.isDir() && !dlg.isTopDir()) {
			if (info.extension(false) != "png") {
				QDir dir = info.dir(true);
				QString fname = info.fileName();
				info.setFile(dir, fname + ".png");
			}
			if (info.exists()) {
				if (QMessageBox::warning( this, "FreeNote Qt", "file " + info.fileName() + "\n already exists.\n\n OK to overwrite ?", "OK", "Cancel", 0, 1, 1 )) {
					return;
				}
			}
			_canvas->exportPNG(info, save);
			_prepng = info.absFilePath();
			conf.writeEntry("png", info.dirPath() + "/");
		}
	}
}

//PDFへの出力
void FrmMain::exportPDF()
{
	_prepdf = "";
	Config conf("FreeNoteQt");
	conf.setGroup("Format");

	QFileInfo info = _file;
	if (info.fileName() == "") {
		info.setFile(QDir(conf.readEntry("pdf", info.dirPath())), "");
	} else {
		info.setFile(QDir(conf.readEntry("pdf", info.dirPath())), info.fileName());
	}

	//_frmPalette->close();
	FNFileDialog dlg(this, "*.pdf", "FreeNote Qt - exportPDF", false);
	if (info.extension()=="free") {
		QString tmpf = info.absFilePath();
		tmpf = tmpf.left(tmpf.findRev(".free"));
		info.setFile(tmpf);
	} else {
		info.setFile(info.dir(), "");
	}

	dlg.setCurrentFile(info);
	dlg.showMaximized();

	if (dlg.exec() && !dlg.isTopDir()) {
		info = dlg.currentFile();
		if (!info.isDir() && !dlg.isTopDir()) {
			if (info.extension(false) != "pdf") {
				QDir dir = info.dir(true);
				QString fname = info.fileName();
				info.setFile(dir, fname + ".pdf");
			}
			if (info.exists()) {
				if (QMessageBox::warning( this, "FreeNote Qt", "file " + info.fileName() + "\n already exists.\n\n OK to overwrite ?", "OK", "Cancel", 0, 1, 1 )) {
					return;
				}
			}
			_canvas->exportPDF(info);
			_prepdf = info.absFilePath();
			conf.writeEntry("pdf", info.dirPath() + "/");
		}
	}
}

//スクロール
void FrmMain::scroll() 
{
	if (!_isTracking) {
		_isTracking = true;
		return;
	}
	if (_canvas->isDrawing()) {
		return;
	}
	int ox = _hscb->value(); 
	int oy = _vscb->value();
	_canvas->setOrigin(ox, oy);
	int mx = _hscb->maxValue();
	int my = _vscb->maxValue();
	if (ox + 50 > mx) {
		_hscb->setMaxValue(mx + 100);
	}
	if (oy + 50 > my) {
		_vscb->setMaxValue(my + 100);
	}
	this->setFocus();
}

//終了
void FrmMain::quit()
{
	_options.txtBoxRect = _canvas->txtBoxRect();
	_options.save();
	showNormal();
	close();
}

//終了前処理
void FrmMain::closeEvent(QCloseEvent* e)
{
	if (!_options.isQuitQuickly) {
		if (QMessageBox::warning( this, "FreeNote Qt", "OK to quit ?", "OK", "Cancel", 0, 1, 1 )) {
			return;
		}
	}
	e->accept();
}

//リターン押下処理
void FrmMain::hitRet()
{
	_canvas->erase();
	_canvas->CR();
}

//キー押下イベント
void FrmMain::keyPressEvent(QKeyEvent* evt) 
{
	if (!_btnZoom->isOn()) {
		int key = evt->key();
		switch (key) {
		case Qt::Key_Return:
		case Qt::Key_Space:
		case Qt::Key_F33:
			_canvas->erase();
			_canvas->CR();
			break;
		case Qt::Key_Left:
			if (_canvas->isSelected()) {
				_canvas->selectionMoveTo(-1, 0);
			} else {
				_hscb->subtractPage();
				scroll();
			}
			break;
		case Qt::Key_Right:
			if (_canvas->isSelected()) {
				_canvas->selectionMoveTo(1, 0);
			} else {
				_hscb->addPage();
				scroll();
			}
			break;
		case Qt::Key_Up:
			if (_canvas->isSelected()) {
				_canvas->selectionMoveTo(0, -1);
			} else {
				_vscb->subtractPage();
				scroll();
			}
			break;
		case Qt::Key_Down:
			if (_canvas->isSelected()) {
				_canvas->selectionMoveTo(0, 1);
			} else {
				_vscb->addPage();
				scroll();
			}
			break;
		default:
			break;
		}
	}
}

void FrmMain::showLayer()
{
	FNLayerDlg dlg(_canvas);
	_canvas->resetSelection();
	dlg.show();
	dlg.exec();
	setTitle();
}

/*  
 *  Destroys the object and frees any allocated resources
 */
FrmMain::~FrmMain()
{
    // no need to delete child widgets, Qt does it all for us
    	delete _colorSelector;
}

//about boxの表示
void FrmMain::about()
{
	char buf[1024];
	sprintf(buf, "FreeNote Qt\nversion %s\nCopyright(c) 2003-2005,jojo3", VERSION);
	QMessageBox::about(this, "FreeNote Qt", buf);
}

void FrmMain::setTitle(QFileInfo* file) {
	if (NULL != file) {
		_title = file->fileName();
	}
	QString t = "FreeNote Qt[";
	if (_canvas->isTinyPaging()) {
		_layer_menu->setItemChecked(_id_tinyPaging, true);
		t += "P:";
	} else {
		_layer_menu->setItemChecked(_id_tinyPaging, false);
		t += "L:";
	}
	t += _canvas->currentLayerName();
	t += "] ";
	setCaption(t + _title);
}
