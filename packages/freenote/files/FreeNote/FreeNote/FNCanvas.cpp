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

2004/11/24 FreeNote 1.11.0pre
・テキストペースト機能

2004/10/17 FreeNote 1.10.0リリース
2004/08/26 ver 1.9.3pre
・罫線機能を追加

2004/05/23 ver 1.9.1Apre
・欧文環境対応

2004/02/16 ver 1.7.3pre
・編集機能強化

2004/02/14 ver 1.7.2pre
・検索機能追加

2004/02/12 ver 1.7.1pre
・フォント仕様の変更
・テキスト処理の高速化
・テキストボックスの多機能化

2003/02/10 ver 1.7.0pre
・文字入力

2003/12/23 ver 1.6.1
・保存情報のサイズ縮小

2003/12/16-19 ver 1.5.5pre
・ペンサイズの追加(1-8)
・アンドゥ・リドゥの実装

2003/12/14 ver 1.5.4pre
・ペンサイズを選択可能に。

2003/12/05 ver 1.5.3Apre
・グリッドの色を修正

2003/12/04 ver 1.5.3pre
・グリッドの描画を一部修正

2003/11/10 ver 1.5.1pre
・曲線整形モード追加

2003/11/09 ver 1.5.0pre
・自動整形モード追加

2003/09/03 ver 1.3.4pre
・Use all quadrant OFF時に表示位置がリセットされる場合があるバグ対応。

2003/09/01-03 ver 1.3.3pre
・スクロールの改良
・Use all quadrant(全象限を使用する)メニューを追加

2003/08/31 FreeNote 1.3.2pre
・全方向スクロール

2003/08/23 FreeNote 1.3.0pre
・CR動作の修正

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
#include "fncanvas.h"
#include <qsjiscodec.h> 
#include <stdio.h>
#include <qfile.h>
#include <qmessagebox.h>
#include <qtextstream.h>
#include <qpen.h>
#include <qcolor.h>
#include <qpoint.h>
#include <qthread.h>
#include <qimage.h>
#include <math.h>
#include <qtextcodec.h>
#include <qmultilineedit.h>
#include <qbitmap.h>
#include "fnmessagebox.h"
#include "fmtengine.h"
#include "fntextdialog.h"
#include <qfont.h>
#include <qapplication.h>
#include <qclipboard.h>
#include "frmmain.h"
#include "fnlayerdlg.h"
#include <stdlib.h>

int snap(int v) {
	int tv = abs(v);
	tv = ((int)(tv + SNAP_SIZE / 2) / SNAP_SIZE) * SNAP_SIZE;
	if (0 > v) {
		return -tv;
	} else {
		return tv;
	}
}

FNCanvas::FNCanvas(FNColorDialog* dlg, QWidget* parent, const char* name, WFlags f)
	:QWidget(parent, name, f),
	_txtTmp(NULL),
	_pen(black, 1, SolidLine, RoundCap, RoundJoin), 
	_asMode(AS_NONE),
	_drawMode(MODE_DRAW),
	_prevMode(MODE_DRAW),
	_eraser_l(50),
	_eraser_s(10),
	_h_step(100),
	_v_step(100),
	_margin(5),
	_scrollTiming(800),
	_selIdx(0),
	_viewMode(false),
	_isWaiting(false),
	_isDragging(false),
	_isDrawing(false),
	_isHeadingEnables(false),
	_isShowGuide(false),
	_isUseAllQuadrant(false),
	_showRuler(false),
	_isTinyPaging(false),
	_scale_x(1.0),
	_scale_y(1.0),
	_tboxRect(0, 50, 220, 240),
	_isEraseWaiting(false),
	_colorSelector(dlg),
	_isColorRevision(true)
{
	_tracks.setAutoDelete(true);
	_clipboard.setAutoDelete(true);
	_current = new FNLayer();
	_layers.append(_current);
	_layers.setAutoDelete(true);
	_undobuf.setAutoDelete(true);
	_current->Name = "Layer0";
	this->setBackgroundMode(NoBackground);
	_timer = new QTimer(this);
	connect(_timer, SIGNAL(timeout()), this, SLOT(autoScroll()));
	_dlgFind = new FNFindDialog(this, "Find");
	connect(_dlgFind, SIGNAL(originChanged(int, int)), this, SLOT(setOrigin(int, int)));
	connect(_dlgFind, SIGNAL(resetOrigin()), this, SLOT(resetOrigin()));
	
}

FNCanvas::~FNCanvas()
{
	_timer->stop();
	delete _timer;

	_tracks.clear();
	_layers.clear();
	//clearList(_draws);
	
	delete _dlgFind;
}


void FNCanvas::addLayer()
{
	FNLayer* layer = new FNLayer();
	_current=layer;
	uint cnt = _layers.count();
	while (1) {
		QString name = "Layer";
		name += QString::number(cnt);

		bool nameExists = false;
		for (uint i = 0; i < _layers.count(); ++i) {
			if (_layers.at(i)->Name == name) {
				nameExists = true;
				break;
			}
		}
		if (false == nameExists) {
			layer->Name = name;
			break;
		}
		++cnt;
	}
	_layers.append(layer);
	_selIdx = _layers.count() - 1;
	redraw();
	
}

//表示レイヤーを下に移動する
void FNCanvas::moveAboveLayer()
{
	--_selIdx;
	if (0 > _selIdx) {
		_selIdx = 0;
	}
	_current = _layers.at(_selIdx);
	redraw();
}

//表示レイヤーを上に移動する
void FNCanvas::moveBelowLayer()
{
	++_selIdx;
	if (_layers.count() - 1 <= (uint)_selIdx) {
		_selIdx = _layers.count() - 1;
	}
	_current = _layers.at(_selIdx);
	redraw();
}


void FNCanvas::setScrollTiming(int v)
{
	_scrollTiming = v;
}


void FNCanvas::setVStep(int v)
{
	_v_step = v;
}

void FNCanvas::setHStep(int v)
{
	_h_step = v;
}

void FNCanvas::setSEraser(int v)
{
	_eraser_s = v;
}

void FNCanvas::setLEraser(int v)
{
	_eraser_l = v;
}


void FNCanvas::setMargin(int v)
{
	if (v < 3) {
		v = 3;
	}
	_margin = v;
}
void FNCanvas::find()
{
	if (_viewMode) {
		return;
	}
	_dlgFind->setElements(_layers);
	_dlgFind->show();
	_dlgFind->exec();
}

void FNCanvas::setScrollMode(int as)
{
	_asMode = as;
	redraw();
}

void FNCanvas::autoScroll()
{
	if (MODE_ERASE == _drawMode) {
		if (0 < _selection.width()) {
			int hsn = SNAP_SIZE / 2;
			int qsn = hsn / 2;
			int x = ((_selection.x() - qsn) / hsn) * hsn;
			int y = ((_selection.y() - qsn) / hsn) * hsn;
			int dx = _selection.x() - x;
			int dy = _selection.y() - y;
			int w = ((_selection.width() + dx + hsn) / hsn) * hsn;
			int h = ((_selection.height() + dy + hsn) / hsn) * hsn;
			_selection.setRect(x, y, w, h);
			_isSelected = true;
		}
		_last = QPoint(-1, -1);
		_tracks.clear();
		_isHeadingEnables = false;
		_isEraseWaiting = false;
		redraw();
	} else {
		if (AS_NONE == _asMode) {
			setOrigin(_origin.x(), _origin.y(), false);
			redraw();
			return;
		}
		bool tmp = _isHeadingEnables;
		int dx = 0;
		int dy = 0;
		if (AS_BOTH == _asMode || AS_HORIZONTAL == _asMode) {
			if (_last.x() > width() * (_margin - 1) / _margin) {
				dx = _h_step;
			} else if (_last.x() < width() / _margin) {
				dx = -_h_step;
			}
		}
		if (AS_BOTH == _asMode || AS_VERTICAL == _asMode) {
			if (_last.y() > height() * (_margin - 1) / _margin) {
				dy = _v_step;
			} else if (_last.y() < height() / _margin) {
				dy = -_v_step;
			}
		}
		setOrigin(_origin.x() + dx, _origin.y() + dy, false);
		_isHeadingEnables = tmp;
		redraw();
	}
}

void FNCanvas::drawRect(QPainter& pa, const QRect& r)
{
	int w = width();
	int h = height();
	int sx = r.left();
	int sy = r.top();
	int ex = r.right();
	int ey = r.bottom();
	if (0 > sx) {
		sx = 0;
	}
	if (0 > sy) {
		sy = 0;
	}
	if (h < ey) {
		ey = h;
	}
	if (w < ex) {
		ex = w;
	}
	if (0 <= r.left()) {
		pa.drawLine(sx, sy, sx, ey);
	}
	if (0 <= r.top()) {
		pa.drawLine(sx, sy, ex, sy);
	}
	if (w >= r.right()) {
		pa.drawLine(ex, sy, ex, ey);
	}
	if (h >= r.bottom()) {
		pa.drawLine(sx, ey, ex, ey);
	}
}

void FNCanvas::mousePressEvent(QMouseEvent* evt)
{
	if (!_current->IsShow) {
		return;
	}
	setFocus();
	_timer->stop();
	_tracks.clear();
	_txtwait = 10;
	if (_viewMode) {
		_isWaiting = true;
		_viewMode = false;
		setOrigin((int)((evt->x()) / _scale_x) - width() / 2, (int)((evt->y()) / _scale_y) - height() / 2, false);
		//redraw();
		emit resetViewMode();
	} else if (MODE_CPICK == _drawMode) {
		QRgb c = _buffer.convertToImage().pixel(evt->pos().x(), evt->pos().y());
		emit pickColor(c);
		return;
	} else if (MODE_TEXT == _drawMode) {
		_txtTmp = NULL;
//		_last = evt->pos();
		_last = SnapPoint(evt->pos(), SNAP_SIZE / 4);
		int x = _last.x();
		int y = _last.y();
		for (int i = _current->draws.count() - _current->disp_offset() - 1; i >= 0; --i) {
			FNPolygon* p = _current->draws.at((uint)i);
			if (FN_TEXT == p->type()) {
				QRect r = p->boundingRect();
				if (r.contains(x, y)) {
					_txtTmp = (FNText*)p;
					_selection.setRect(0, 0, -1, -1);
					_tdx = _last.x() - r.x();
					_tdy = _last.y() - r.y();
					break;
				}
			}
		}
	} else if (MODE_ERASE == _drawMode) {
		if (_isEraseWaiting) {
			return;
		}
		_last = evt->pos();
		
		if (0 >= _selection.width() || !_selection.contains(_last)) {
			_isSelected = false;
		}
		if (!_isSelected) {
			_selection = QRect(0, 0, -1, -1);
			_selected.clear();
			redraw();

			int w = _eraser_s;
			if (PENWIDTH_MAX / 2 < _pen.width()) {
				w = _eraser_l;
			}
			// 大バグ対策：
			// 0 > xの座標に、縦150位の四角形を書くと、C系ザウのパフォーマンスが激落ちします。
			// 以降同様のロジックはこの対策のためです。
			QPainter pwin;
			pwin.begin(this);
			pwin.setRasterOp(XorROP);
			pwin.setPen(QPen(white, 1));
			_preRect.setRect(_last.x() - w / 2, _last.y() - w / 2, w, w);
			drawRect(pwin, _preRect);
			pwin.flush();
			pwin.end();
			_selection = QRect(0, 0, -1, -1);
			_selected.clear();
		} else {
			QPainter pwin;
			pwin.begin(this);

			pwin.setRasterOp(XorROP);
			pwin.setPen(QPen(white, 1));
			_preRect.setRect(_selection.x(), _selection.y(), _selection.width(), _selection.height());
			drawRect(pwin, _preRect);

			pwin.flush();
			pwin.end();
			QPoint t = SnapPoint(QPoint(_selection.x(), _selection.y()));
			_last = SnapPoint(_last);

			_tdx = _last.x() - t.x();
			_tdy = _last.y() - t.y();
		}
	} else {
		_last = evt->pos();
		_tracks.append(new QPoint(_last));
	}
	_isDragging = true;
}

void FNCanvas::mouseMoveEvent(QMouseEvent* evt)
{
	if (!_current->IsShow) {
		return;
	}
	if (_isWaiting) {
		return;
	}
	if (MODE_TEXT == _drawMode) {
		if (NULL == _txtTmp) {
			return;
		}
		if (0 < _txtwait) {
			--_txtwait;
			return;
		}
		QPainter pwin;
		pwin.begin(this);
		if (-1 != _selection.width()) {
			pwin.setRasterOp(XorROP);
			pwin.setPen(QPen(white, 1));
			drawRect(pwin, _selection);
		} else {
			_selection = _txtTmp->boundingRect();
		}
		QPoint tmp = SnapPoint(evt->pos(), SNAP_SIZE / 4);
		tmp.setX(tmp.x() - _tdx);
		tmp.setY(tmp.y() - _tdy);
		if (tmp != _last) {
			_selection.moveTopLeft(tmp);
			_last = tmp;
		}
		drawRect(pwin, _selection);
		pwin.flush();
		pwin.end();
	} else if (MODE_CPICK == _drawMode) {
		QRgb c = _buffer.convertToImage().pixel(evt->pos().x(), evt->pos().y());
		emit pickColor(c);
		return;
	} else if (MODE_ERASE == _drawMode) {
		//redraw();
		if (_last.x() == -1) {
			return;
		}
		if (!_isSelected) {
			int w = _eraser_s;
			if (PENWIDTH_MAX / 2 < _pen.width()) {
				w = _eraser_l;
			}
			QPainter pwin;
			pwin.begin(this);

			pwin.setRasterOp(XorROP);
			pwin.setPen(QPen(white, 1));
			drawRect(pwin, _preRect);

			_last = evt->pos();

			_preRect.setRect(_last.x() - w / 2, _last.y() - w / 2, w, w);
			pwin.setRasterOp(CopyROP);
			QRect r = QRect(0, 0, width(), height());
			for (uint i = 0; i < _current->draws.count() - _current->disp_offset(); ++i) {
				FNPolygon* p = _current->draws.at(i);
				QRect bounds = p->boundingRect();
				if (r.intersects(bounds)) {
					bool f = false;
					QRect& selected = _preRect;
					for (uint j = 0; j < p->points().count(); ++j) {
						QPoint& pts = p->points().at(j);
						if (selected.contains(pts)) {
							f = true;
							if (-1 == _selection.width()) {
								_selection = bounds;
							} else {
								if (bounds.x() < _selection.x()) {
									_selection.setX(bounds.x());
								}
								if (bounds.y() < _selection.y()) {
									_selection.setY(bounds.y());
								}
								if (bounds.right() > _selection.right()) {
									_selection.setRight(bounds.right());
								}
								if (bounds.bottom() > _selection.bottom()) {
									_selection.setBottom(bounds.bottom());
								}
							}
							break;
						}
					}
					if (f) {
						if (0 == _selected.contains(p)) {
							_selected.append(p);
						}
						p->drawShape(pwin, f);
					}
				}
			}
			pwin.setRasterOp(XorROP);
			pwin.setPen(QPen(white, 1));
			drawRect(pwin, _preRect);
			pwin.flush();
			pwin.end();
		} else {
			if (0 >= _selection.width()) {
				return;
			}
			//選択中(移動処理)
			QPainter pwin;
			pwin.begin(this);
			pwin.setRasterOp(XorROP);
			pwin.setPen(QPen(white, 1));
			drawRect(pwin, _preRect);
			_last = SnapPoint(evt->pos(), SNAP_SIZE / 4);
			_preRect.setRect(_last.x() - _tdx, _last.y() - _tdy, _selection.width(), _selection.height());
			drawRect(pwin, _preRect);
			pwin.flush();
			pwin.end();
		}
	} else {
		QPainter pwin;
		pwin.begin(this);
		pwin.setPen(_pen);

		pwin.drawLine(_last, evt->pos());
		pwin.flush();

		pwin.end();
		_last = evt->pos();
		_tracks.append(new QPoint(_last));
	}
}

void FNCanvas::mouseReleaseEvent(QMouseEvent* evt)
{
	if (!_current->IsShow) {
		return;
	}
	_isDragging = false;
	if (_isWaiting) {
		_isWaiting = false;
		return;
	}
	if (MODE_ERASE == _drawMode) {
		if (_isSelected) {
			//_lastへ移動
			_last = SnapPoint(evt->pos(), SNAP_SIZE / 4);
			int dx = _last.x() - _tdx - _selection.x();
			int dy = _last.y() - _tdy - _selection.y();
			for (uint i = 0; i < _selected.count(); ++i) {
				FNPolygon* p = _selected.at(i);
				p->translate(dx, dy);
			}
			_selection.moveBy(dx, dy);
			redraw();
		} else {
			if (false == _isEraseWaiting) {
				_isEraseWaiting = true;
			}
			redraw();
			_timer->start(_scrollTiming, true);
		}
	} else if (MODE_CPICK == _drawMode) {
		QRgb c = _buffer.convertToImage().pixel(evt->pos().x(), evt->pos().y());
		emit pickColor(c);
		emit changeMode(_prevMode);
		return;
	} else {
		if (1 < _tracks.count()) {
			_last = evt->pos();
			FNPolygon* p = NULL;
			if (MODE_FORMAT == _drawMode) {
				p = new FNPolygon(_pen);
				_tracks = AutoFormat(_tracks);
			} else if (MODE_CURVE == _drawMode) {
				QPoint sp = SnapPoint(*_tracks.at(0));
				QPoint ep = SnapPoint(*_tracks.at(_tracks.count()-1));
				FNPointList tracks;
				tracks.setAutoDelete(true);
				for (uint i = 0; i < _tracks.count(); ++i) {
					QPoint t = *_tracks.at(i);
					tracks.append(new QPoint(t.x(), t.y()));
				}
				_tracks = AutoCurve(_tracks);
				bool isEllipse = false;
				if (sp == ep) {
					if (0 < _tracks.count()) {
						int vdconv = 0; //縦方向転換
						int vdir = 0;
						int svdir = 0;
						
						int hdconv = 0; //横方向転換
						int hdir = 0;
						int shdir = 0;
						QPoint* st = _tracks.at(0);
						QPoint* l = st;
						for (uint i = 1; i < _tracks.count(); ++i) {
							QPoint* p = _tracks.at(i);
							int thdir = sign(p->x() - l->x());
							if (l->x() != p->x()) {
								//水平方向転換
								if (0 != thdir) {
									if (0 == hdir) {
										shdir = thdir;
									} else if (thdir != hdir) {
										++hdconv;
									}
									hdir = thdir;
								}
							}
							int tvdir = sign(p->y() - l->y());
							if (l->y() != p->y()) {
								//垂直方向転換
								if (0 != tvdir) {
									if (0 == vdir) {
										svdir = tvdir;
									} else if (tvdir != vdir) {
										++vdconv;
									}
									vdir = tvdir;
								}
							}
							l = p;
						}
						if (shdir == hdir) {
							--hdconv;
						}
						if (svdir == vdir) {
							--vdconv;
						}

						if (1 >= hdconv && 1 >= vdconv) {
							isEllipse = true;
							int dircnt = 0;
							//もう１判定
							tracks = AutoFormat(tracks);
							if (2 < tracks.count()) {
								int phdir = sign(tracks.at(1)->x() - tracks.at(0)->x());
								int pvdir = sign(tracks.at(1)->y() - tracks.at(0)->y());
								l = tracks.at(1);
								for (uint i = 2; i < tracks.count(); ++i) {
									QPoint* p = tracks.at(i);
									int thdir = sign(p->x() - l->x());
									int tvdir = sign(p->y() - l->y());
									if ((0 == pvdir && 0 != tvdir && 0 != phdir && 0 == thdir) ||
										(0 != pvdir && 0 == tvdir && 0 == phdir && 0 != thdir))
									{
										if (3 < dircnt) {
											isEllipse = false;
											break;
										}
										++dircnt;
									}
									l = p;
									phdir = thdir;
									pvdir = tvdir;
								}
							}
						}
					}
				}
				if (isEllipse) {
					QRect r = GetBounds(_tracks);
					_tracks.clear();
					sp = SnapPoint(QPoint(r.x(), r.y()));
					ep = SnapPoint(QPoint(r.x() + r.width(), r.y() + r.height()));
					_tracks.append(new QPoint(sp.x(), sp.y()));
					_tracks.append(new QPoint(ep.x(), ep.y()));
					p = new FNEllipse(_pen);
				} else if (2 < _tracks.count()) {
					p = new FNBezier(_pen);
				} else {
					p = new FNPolygon(_pen);
				}
			} else if (MODE_SMOOTH == _drawMode) {
				_tracks = Smoothing(_tracks);
				if (2 < _tracks.count()) {
					p = new FNBezier(_pen);
				} else {
					p = new FNPolygon(_pen);
				}
			} else {
				_tracks = Reduce(_tracks);
				p = new FNPolygon(_pen);
			}
			if (NULL != p) {
				p->setFill(_fill);
				if (1 < _tracks.count()) {
					p->setPoints(_tracks);
					redobuf_flush();
					_current->draws.append(p);
				}
			}
		} else if (MODE_TEXT == _drawMode) {
			if (NULL == _txtTmp) {
				textEdit(_last.x(), _last.y());
			} else {
				QRect r = _txtTmp->boundingRect();
				if (_selection == r || 0 < _txtwait) {
					textEdit(r.x(), r.y(), _txtTmp);
				} else {
					if (-1 != _selection.width()) {
						_txtTmp->translate(_last.x() - r.x(), _last.y() - r.y());
					}
				}
			}
			_txtTmp = NULL;
		}
		_tracks.clear();
		_isHeadingEnables = true;
		_timer->start(_scrollTiming, true);
	}
}

void FNCanvas::textEdit(int x, int y, FNText* obj)
{
	FNTextDialog dlg(fontname, _colorSelector, this);
	dlg.show();
	/*
	if (width() < _tboxRect.x()) {
		_tboxRect.setX(0);
	}
	if (50 > _tboxRect.y()) {
		_tboxRect.setY(50);
	}
	if (height() < _tboxRect.height()) {
		_tboxRect.setHeight(height());
	}
	if (width() < _tboxRect.width()) {
		_tboxRect.setWidth(width());
	}
	dlg.move(_tboxRect.x(), _tboxRect.y());
	dlg.resize(_tboxRect.width(), _tboxRect.height());
	*/
	dlg.move(width() / 8, height() / 8);
	dlg.resize(width() * 6 / 8, height() * 6 / 8);
	QPen pen = _pen;
	if (NULL != obj) {
		for (uint i = 0; i < obj->lines.count(); ++i) {
			dlg.lines->append(obj->lines[i]);
		}
		pen = obj->pen();
	}
	dlg.setPen(pen);
	
	int mx = x;
	int my = y;
	if (dlg.exec()) {
		pen = dlg.pen();
		if (0 < dlg.lines->text().length()) {
			FNText* p = obj;
			if (NULL == obj) {
				p = new FNText(pen);
				_current->draws.append((FNPolygon*)p);
			}
			p->pen() = pen;
			p->lines.clear();
			FNPointList l;
			l.append(new QPoint(x, y));
			QFont font(fontname);
			font.setPointSize(FONTSIZE[pen.width()]);
			QFontMetrics fm(font);
			int h = fm.height();
			for (int i = 0; i < dlg.lines->numLines(); ++i) {
				p->lines.append(dlg.lines->textLine(i));
				int w = fm.width(dlg.lines->textLine(i)) + x;
				l.append(new QPoint(w, my));
				my += h;
				l.append(new QPoint(w, my));
				l.append(new QPoint(x, my));
				if (mx < w) {
					mx = w;
				}
			}
			p->setPoints(l);
			redobuf_flush();
			redraw();
		} else {
			if (NULL != obj) {
				_current->draws.remove(obj);
			}
		}
	}
	_tboxRect = QRect(dlg.x(), dlg.y(), dlg.width(), dlg.height());
}
void FNCanvas::paintEvent(QPaintEvent*)
{
	bitBlt(this, 0, 0, &_buffer);
}

void FNCanvas::resizeEvent(QResizeEvent* evt)
{
	QPixmap save(_buffer);
	_buffer.resize(evt->size());
	_buffer.fill(white);
	bitBlt(&_buffer, 0, 0, &save);
	redraw();
}

void FNCanvas::setOrigin(QPoint& o)
{
	this->setOrigin(o.x(), o.y());
}

QPoint FNCanvas::getTopLeft()
{
	bool hasValue = false;
	int dx = 0;
	int dy = 0;
	if (0 < _current->draws.count()) {
		dx = ((FNPolygon*)_current->draws.at(0))->boundingRect().x();
		dy = ((FNPolygon*)_current->draws.at(0))->boundingRect().y();
	}
	
	for (uint j = 0; j < _layers.count(); ++j) {
		FNPolygonList& draws = _layers.at(j)->draws;
		for (uint i = 0; i < draws.count(); ++i) {
			FNPolygon* p = draws.at(i);
			hasValue = true;
			if (dx > p->boundingRect().x()) {
				dx = p->boundingRect().x();
			}
			if (dy > p->boundingRect().y()) {
				dy = p->boundingRect().y();
			}
		}
	}
	if (!hasValue || !_isUseAllQuadrant) {
		return _origin;
	}
	return QPoint(snap(dx), snap(dy));
}


void FNCanvas::rebuild()
{
	if (!_isUseAllQuadrant) {
		return;
	}

	QPoint d = getTopLeft();
	d.setX(d.x() - SNAP_SIZE);
	d.setY(d.y() - SNAP_SIZE);
	for (uint j = 0; j < _layers.count(); ++j) {
		FNPolygonList& draws = _layers.at(j)->draws;
		for (uint i = 0; i < draws.count(); ++i) {
			FNPolygon* p = draws.at(i);
			p->translate(-d.x(), -d.y());
		}
	}
	_origin = QPoint(0, 0);
}

void FNCanvas::resetOrigin()
{
	int ox = 0;
	int oy = 0;
	_isHeadingEnables = false;
	_timer->stop();


	int dx = 0;
	int dy = 0;
	if (!_isUseAllQuadrant) {
		if (0 > ox) {
			ox = 0;
		}
		if (0 > oy) {
			oy = 0;
		}
		dx = _origin.x() - ox;
		dy = _origin.y() - oy;
	} else {
		dx = _origin.x() - ox;
		dy = _origin.y() - oy;
		if (0 > ox) {
			ox = 0;
		}
		if (0 > oy) {
			oy = 0;
		}
	}
	for (uint i = 0; i < _tracks.count(); ++i) {
		QPoint* p = _tracks.at(i);
		p->setX(p->x() + dx);
		p->setY(p->y() + dy);
	}

	for (uint i = 0; i < _layers.count(); ++i) {
		FNPolygonList& draws = _layers.at(i)->draws;
		for (uint j = 0; j < draws.count(); ++j) {
			FNPolygon* p = draws.at(j);
			p->translate(dx, dy);
		}
	}
	_origin = QPoint(ox, oy);
}

void FNCanvas::setOrigin(int ox, int oy, bool isRedrawEnabled)
{
	ox = snap(ox);
	oy = snap(oy);
	_isHeadingEnables = false;
	_timer->stop();

	int dx = 0;
	int dy = 0;
	if (!_isUseAllQuadrant) {
		if (0 > ox) {
			ox = 0;
		}
		if (0 > oy) {
			oy = 0;
		}
		dx = _origin.x() - ox;
		dy = _origin.y() - oy;
	} else {
		dx = _origin.x() - ox;
		dy = _origin.y() - oy;
		if (0 > ox) {
			ox = 0;
		}
		if (0 > oy) {
			oy = 0;
		}
	}
	if (dx == 0 && dy == 0) {
		return;
	}
	for (uint i = 0; i < _tracks.count(); ++i) {
		QPoint* p = _tracks.at(i);
		p->setX(p->x() + dx);
		p->setY(p->y() + dy);
	}

	for (uint j = 0; j < _layers.count(); ++j) {
		FNPolygonList& draws = _layers.at(j)->draws;
		for (uint i = 0; i < draws.count(); ++i) {
			FNPolygon* p = draws.at(i);
			p->translate(dx, dy);
		}
	}
	if (-1 != _selection.width()) {
		_selection.moveBy(dx, dy);
	}

	_origin = QPoint(ox, oy);
	emit originChanged(ox, oy);
	if (isRedrawEnabled) {
		redraw();
	}
}

void FNCanvas::redraw()
{
	if (_isDrawing) {
		return;
	}
	if (_isDragging) {
		return;
	}
	if (!this->isVisible()) {
		return;
	}
	
	_isDrawing = true;
	for (uint l = 0; l < _layers.count(); ++l) {
		FNLayer& layer = *_layers.at(l);
		if (_isTinyPaging) {
			if (_current == &layer) {
				layer.IsShow = true;
			} else {
				layer.IsShow = false;
			}
		}
	}
	int h = height(); //(height() / 40) * 40;
	_buffer.fill(white);
	QRect r = QRect(0, 0, width(), height());
	QPainter pbuf;
	pbuf.begin(&_buffer);
	pbuf.setFont(QFont(fontname));
	pbuf.setClipRect(0, 0, width(), height());
	if (_viewMode) {
		float wx = 0;
		float wy = 0;
		for (uint l = 0; l < _layers.count(); ++l) {
			FNLayer& layer = *_layers.at(l);
			if (layer.IsShow) {
				FNPolygonList& draws = layer.draws;
				for (uint i = 0; i < draws.count() - layer.disp_offset(); ++i) {
					FNPolygon* p = draws.at(i);
					QRect r = p->boundingRect();
					if (wx < r.right()) {
						wx = r.right();
					} 
					if (wy < r.bottom()) {
						wy = r.bottom();
					}
				}
			}
		}
		wx += SNAP_SIZE;
		wy += SNAP_SIZE;
		wx = snap((int)wx);
		wy = snap((int)wy);
		wx = wx + _origin.x();
		wy = wy + _origin.y();
		_scale_x = (float)width() / wx;
		_scale_y = (float)height() / wy;
		if (1.0f < _scale_x) { 
			_scale_x = 1.0f;
		}
		if (1.0f < _scale_y) {
			_scale_y = 1.0f;
		}
		if (_scale_x > _scale_y) {
			_scale_x = _scale_y;
		} else if (_scale_x < _scale_y) {
			_scale_y = _scale_x;
		}
		for (uint l = 0; l < _layers.count(); ++l) {
			FNLayer& layer = *_layers.at(l);
			if (!layer.IsShow) {
				continue;
			}
			FNPolygonList& draws = layer.draws;
			for (uint i = 0; i < draws.count() - layer.disp_offset(); ++i) {
				FNPolygon* p = draws.at(i);
				FNPolygon* t = NULL;
				if (p->type() == FN_BEZIER) {
					t = new FNBezier(*(FNBezier*)p);
				} else if (p->type() == FN_ELLIPSE) {
					t = new FNEllipse(*(FNEllipse*)p);
				} else if (p->type() == FN_TEXT) {
					t = new FNText(*(FNText*)p);
				} else {
					t = new FNPolygon(*p);
				}
				t->translate(-_origin.x(), -_origin.y());
				for (uint j = 0; j < t->points().count(); ++j) {
					QPoint& pts = t->points().at(j);
					int x = (int)(pts.x() * _scale_x);
					int y = (int)(pts.y() * _scale_y);
					pts.setX(x);
					pts.setY(y);
				}
				double pensize = t->pen().width();
				if (_scale_x > _scale_y) {
					pensize = pensize * _scale_y;
				} else {
					pensize = pensize * _scale_x;
				}
				if (0 >= pensize) {
					pensize = 1;
				}
				if (p->type() == FN_TEXT) {
					FNText* tp = (FNText*)t;
					QPoint& sp = t->points().at(0);

					//default font size checking...
					QFont f(fontname, FONTSIZE[p->pen().width()]);
					QFontMetrics fm(f);
					int h = fm.height();
					int wx = 0;
					int wy = 0;
					for (uint i = 0; i < tp->lines.count(); ++i) {
						int tw = fm.width(tp->lines[i]);
						if (tw > wx) {
							wx = tw;
						}
						wy += h;
					}

					//create default font image...
					QRect r = tp->boundingRect();
					QPixmap tmp(wx + 1, wy + 1);
					tmp.fill(Qt::white);
					QPainter pt;
					pt.begin(&tmp);
					pt.setFont(f);
					pt.setPen(p->pen());
					int y = h + 1;
					for (uint i = 0; i < tp->lines.count(); ++i) {
						pt.drawText(1, y, tp->lines[i]);
						y += h;
					}
					pt.flush();
					pt.end();

					//draw to font image
					tmp = tmp.convertToImage().smoothScale(r.width(), r.height());
					tmp.setMask(tmp.createHeuristicMask());
					pbuf.drawPixmap(sp.x(), sp.y(), tmp);
					pbuf.flush();
				} else {
					t->pen().setWidth(pensize);
					t->drawShape(pbuf);
				}
				delete t;
			}
		}
	} else {
		if (MODE_ERASE == _drawMode || MODE_FORMAT == _drawMode || MODE_CURVE == _drawMode || MODE_TEXT == _drawMode) {
			//グリッド描画
			//QPen pen2(QColor(0, 0, 0), 1);
			//pbuf.setPen(QPen(QColor(50, 240, 240), 1));
			pbuf.setPen(QPen(GridColor));
			for (int x = 0; x < width() + SNAP_SIZE; x += SNAP_SIZE) {
				pbuf.drawLine(x - SNAP_SIZE / 2, 0, x - SNAP_SIZE / 2, h);
				for (int y = 0; y < h + SNAP_SIZE; y += SNAP_SIZE) {
					pbuf.drawLine(0, y - SNAP_SIZE / 2, width(), y - SNAP_SIZE / 2);
					pbuf.drawRect(x-1,y-1,2,2);
				}
			}
		}
		if (MODE_ERASE != _drawMode) {
			if (!(MODE_FORMAT == _drawMode || MODE_CURVE == _drawMode || MODE_TEXT == _drawMode)) {
				if (_showRuler) {
					//罫線
					pbuf.setPen(QPen(RulerColor, 1, SolidLine));
					int step = SNAP_SIZE * 2; //SNAP_SIZEの２倍に。
					for (int i = 0; i < height(); i += step) {
						pbuf.drawLine(0, i, width(),  i);
					}
				}
			}

			if (_isShowGuide) {
				pbuf.setPen(QPen(GuideColor, 1, DashLine));
				if (AS_HORIZONTAL == _asMode || AS_BOTH == _asMode) {
					if (0 != _origin.x() || _isUseAllQuadrant) {
						pbuf.drawLine(width() / _margin, 0, width() / _margin, h);
					}
					pbuf.drawLine(width() * (_margin - 1) / _margin, 0, width() * (_margin - 1) / _margin, h);
				}

				if (AS_VERTICAL == _asMode || AS_BOTH == _asMode) {
					if (0 != _origin.y() || _isUseAllQuadrant) {
						pbuf.drawLine(0, h / _margin, width(), h / _margin);
					}
					pbuf.drawLine(0, h * (_margin - 1) / _margin, width(), h * (_margin - 1) / _margin);
				}
			}

			for (uint l = 0; l < _layers.count(); ++l) {
				FNLayer& layer = *_layers.at(l);
				if (layer.IsShow) {
					FNPolygonList& draws = layer.draws;
					for (uint i = 0; i < draws.count() - layer.disp_offset(); ++i) {
						FNPolygon* p = draws.at(i);
						if (r.intersects(p->boundingRect())) {
							p->drawShape(pbuf);
						}
					}
				}
			}
		} else {
			for (uint l = 0; l < _layers.count(); ++l) {
				FNLayer& layer = *_layers.at(l);
				if (layer.IsShow) {
					FNPolygonList& draws = layer.draws;
					for (uint i = 0; i < draws.count() - layer.disp_offset(); ++i) {
						FNPolygon* p = draws.at(i);
						if (!_selected.contains(p)) {
							if (r.intersects(p->boundingRect())) {
								p->drawShape(pbuf);
							}
						}
					}
				}
			}
			for (uint i = 0; i < _selected.count(); ++i) {
				_selected.at(i)->drawShape(pbuf, true);
			}
			if (_isSelected) {
				pbuf.setPen(QPen(SelectionFrameColor, 1, DashLine));
				pbuf.setBrush(NoBrush);
				pbuf.drawRect(_selection);
			}
		}
	}
	pbuf.end();
	_isDrawing = false;
	repaint();
}

void FNCanvas::changeColor(QRgb c)
{
	_pen.setColor(QColor(c));
	if (_isSelected && _drawMode == MODE_ERASE) {
		for (uint i = 0; i < _selected.count(); ++i) {
			_selected.at(i)->pen().setColor(QColor(c));
		}
	}
}

void FNCanvas::selectionMoveTo(int dx, int dy)
{
	if (_isSelected) {
		for (uint i = 0; i < _selected.count(); ++i) {
			_selected.at(i)->translate(dx, dy);
		}
		_selection.moveBy(dx, dy);
	}
	redraw();
}

void FNCanvas::copy()
{
	if (MODE_ERASE != _drawMode || _viewMode) {
		return;
	}
	_clipboard.clear();
	int size = _selected.count();
	int a1[size];
	int a2[size];
	for (int i = 0; i < size; ++i) {
		a1[i] = _current->draws.findRef(_selected.at(i));
		a2[i] = i;
	}

	//ソート
	FNPolygonList tmp;
	for (int i = 0; i < size; ++i) {
		int min = i;
		for (int j = i + 1; j < size; ++j) {
			if (a1[min] > a1[j]) {
				min = j; 
			}
		}
		tmp.append(_selected.at(a2[min]));
		a1[min] = a1[i];
		a2[min] = a2[i];
	}
	
	//並び順を保証してコピー
	tmp.clone(_clipboard);
	tmp.clear();
}

void FNCanvas::paste()
{
	if (_viewMode) {
		return;
	}
	if (MODE_ERASE == _drawMode) {
		_selected.clear();
		_clipboard.clone(_selected);
		_selection = QRect(0, 0, -1, -1);
		for (uint i = 0; i < _selected.count(); ++i) {
			FNPolygon* o = _selected.at(i);
			o->translate(10, 10);
			QRect bounds = o->boundingRect();
			if (-1 == _selection.width()) {
				_selection = bounds;
			} else {
				if (bounds.x() < _selection.x()) {
					_selection.setX(bounds.x());
				}
				if (bounds.y() < _selection.y()) {
					_selection.setY(bounds.y());
				}
				if (bounds.right() > _selection.right()) {
					_selection.setRight(bounds.right());
				}
				if (bounds.bottom() > _selection.bottom()) {
					_selection.setBottom(bounds.bottom());
				}
			}
		}
		_selected.copy(_current->draws);
		_isSelected = true;
	} else {
		int my = 10;
		int mx = 10;
		int x = 10;
		QStringList lines = QStringList::split("\n", QApplication::clipboard()->text());
		if (0 < lines.count()) {
			FNText* p = new FNText(_pen);
			_current->draws.append((FNPolygon*)p);
			p->lines.clear();
			FNPointList l;
			l.append(new QPoint(0, 0));
			QFont font(fontname);
			font.setPointSize(FONTSIZE[_pen.width()]);
			QFontMetrics fm(font);
			int h = fm.height();
			for (uint i = 0; i < lines.count(); ++i) {
				p->lines.append(lines[i]);
				int w = fm.width(lines[i]) + x;
				l.append(new QPoint(w, my));
				my += h;
				l.append(new QPoint(w, my));
				l.append(new QPoint(x, my));
				if (mx < w) {
					mx = w;
				}
			}
			p->setPoints(l);
		}
	}
	redraw();
}

void FNCanvas::redo()
{
	if (MODE_ERASE != _drawMode) {
		_current->redo();
	}
	redraw();
}

void FNCanvas::clearList(FNPolygonList& list)
{
	list.setAutoDelete(true);
	list.clear();
	list.setAutoDelete(false);
}

void FNCanvas::resetSelection()
{
	_selection = QRect(0, 0, -1, -1);
	_selected.clear();
	_isSelected = false;
}

void FNCanvas::clear()
{
	resetSelection();
	_layers.clear();
	_current = new FNLayer();
	_layers.append(_current);
	_current->Name = "Layer0";
	_selIdx = 0;
	_isTinyPaging = false;
	//_undobuf.clear();
	setOrigin(0, 0);
	redraw();
}

void FNCanvas::undo()
{
	_timer->stop();
	if (MODE_ERASE != _drawMode) {
		_current->undo();
	} else {
		_selected.clear();
		_isSelected = false;
		_layers.clear();
		for (uint i = 0; i < _undobuf.count(); ++i) {
			_layers.append(new FNLayer(*_undobuf.at(i)));
		}
		_current = _layers.at(0);
		_selIdx = 0;
	}
	redraw();
}

void FNCanvas::viewChanged(bool flg)
{
	_tracks.clear();
	_viewMode = flg;
	if (_viewMode) {
		if (_isUseAllQuadrant) {
			rebuild();
		}
		setOrigin(0, 0, false);
	}
	redraw();
}

void FNCanvas::redobuf_flush()
{
	_current->redobuf_flush();
}

void FNCanvas::modeChanged(int mode)
{
	_tracks.clear();
	resetSelection();
	_drawMode = mode;
	for (uint i = 0; i < _layers.count(); ++i) {
		FNLayer* p = _layers.at(i);
		p->modeChanged();
	}
	_undobuf.clear();
	if (MODE_ERASE == mode) {
		_isEraseWaiting = false;
		for (uint i = 0; i < _layers.count(); ++i) {
			_undobuf.append(new FNLayer(*_layers.at(i)));
		}
	}
	if (MODE_CPICK != mode) {
		_prevMode = mode;
	}
	redraw();
}

QRect FNCanvas::getMatrix(const QRect& r) const
{
	int ox = _origin.x();
	int oy = _origin.y();
	const int wide = 100;

	int left = r.left() + ox;
	int top = r.top() + oy;
	int right = r.right() + ox;
	int bottom = r.bottom() + oy;
	
	left = (int)(left / wide) * wide;
	top = (int)(top / wide) * wide;
	right = (right % wide == 0 && left != right) ? right : (int)((right + wide) / wide) * wide;
	bottom = (bottom % wide == 0 && top != bottom) ? bottom : (int)((bottom + wide) / wide) * wide;
	
	return QRect(left - ox, top - oy, right - left, bottom - top);
}

void FNCanvas::CR() 
{
	if (MODE_ERASE == _drawMode) {
		return;
	}
	int h = height(); //(height() / 40) * 40;
	int step = snap(h) / _margin;
	if (_isHeadingEnables) {
		//lastから、左方向に向けて探索する。
		QRect r = getMatrix(_current->draws.last()->boundingRect());
		bool isSearching = true;
		r.moveBy(-100, 0);
		while (isSearching) {
			isSearching = false;
			for (uint i = 0; i < _current->draws.count(); ++i) {
				FNPolygon* p = _current->draws.at(i);
				const QRect& r2 = p->boundingRect();
				if (r.intersects(r2)) {
					if (r.left() + 100 > r2.left()) {
						r = getMatrix(r2);
						r.moveBy(-100, 0);
						isSearching = true;
						break;
					}
				}
			}
		}
		r.moveBy(100, 0);
		//lastが画面の4/5以下ならば、スクロールアップする。
		//そうでなければ、ヘッディングのみ。
		if (_last.y() > h * 4 / 5) {
			setOrigin(_origin.x() + r.x(), _origin.y() +  step);
		} else {
			setOrigin(_origin.x() + r.x(), _origin.y());
		}
		_isHeadingEnables = false;
	} else {
		//lastの周囲に何も無い場合は、縦にスクロールする。
		setOrigin(_origin.x(), _origin.y() +  step);
	}
}

void FNCanvas::erase()
{
	if (MODE_ERASE != _drawMode) {
		return;
	}
	FNPolygonList temp;
	int w = _eraser_s;
	if (PENWIDTH_MAX / 2 < _pen.width()) {
		w = _eraser_l;
	}
	for (uint i = 0; i < _selected.count(); ++i) {
		_current->draws.remove(_selected.at(i));
		//_marks.append(_selected.at(i));
	}
	resetSelection();
	_tracks.clear();
	_isEraseWaiting = false;
	redraw();
}

void FNCanvas::setPensize(int sz)
{
	_pen.setWidth(sz);
	if (_isSelected) {
		for (uint i = 0; i < _selected.count(); ++i) {
			if (FN_TEXT != _selected.at(i)->type()) {
				_selected.at(i)->pen().setWidth(sz);
			}
		}
	}
}

bool FNCanvas::exportPNG(const QFileInfo& info, QPixmap& buf)
{
	if (0 == info.fileName().length()) {
		QMessageBox::warning(0,"FreeNoteQt", "file name is empty.");
		return false;
	}
	if (info.extension(false) != "png") {
		QMessageBox::warning(0,"FreeNoteQt", "extension '.png' expected.");
		return false;
	}

	bool ret;
	if (_isColorRevision) {
		QImage img = buf.convertToImage();
		int wd = buf.width();
		int ht = buf.height();
		for (int i = 0; i < ht; ++i) {
			for (int j = 0; j < wd; ++j) {
				QRgb c = img.pixel(j, i);
				int r = qRed(c) >> 3;
				int g = qGreen(c) >> 2;
				int b = qBlue(c) >> 3;
				r = (r << 3) | (r >> 2);
				b = (b << 3) | (b >> 2);
				g = (g << 2) | (g >> 4);
				//float f1 = 248f / 255f;
				//float f2 = 252f / 255f;
				//img.setPixel(qRed(c) * f1, qGreen(c) * f2, qBlue(c) * f1);
				img.setPixel(j, i, qRgb(r, g, b));
			}
		}
		ret = img.save(info.absFilePath(), "PNG");
	} else {
		ret = buf.save(info.absFilePath(), "PNG");
	}
	if (ret) {
		FNMessageBox::information(0,"FreeNoteQt", "export PNG complete.");
	} else {
		QMessageBox::warning(0,"FreeNoteQt", "could not export file.");
	}
	return ret;
}

QString FNCanvas::mkPDFscript(FNPolygon* elm, int wy)
{
	QString s ="";
	char buf[1024];
	float r;
	float g;
	float b;
	if (_isColorRevision) {
		r = (float)elm->pen().color().red() / 248.0f;
		g = (float)elm->pen().color().green() / 252.0f;
		b = (float)elm->pen().color().blue() / 248.0f;
	} else {
		r = (float)elm->pen().color().red() / 255.0f;
		g = (float)elm->pen().color().green() / 255.0f;
		b = (float)elm->pen().color().blue() / 255.0f;
	}
	if (elm->type() == FN_TEXT) {
		FNText* t = (FNText*)elm;
		sprintf(buf, "BT\r\n/F1 %d Tf\r\n", FONTSIZE[elm->pen().width()]);
		s += buf;
		sprintf(buf, "0 Tr\r\n%f %f %f rg\r\n", r, g, b);
		s += buf;
		QRect r = t->boundingRect();
		r.moveBy(_origin.x(), _origin.y());
		QFont font(fontname);
		font.setPointSize(FONTSIZE[elm->pen().width()]);
		QFontMetrics fm(font);
		int h = fm.height();
		int y = r.y() + h;
		for (uint i = 0; i < t->lines.count(); ++i) {
			sprintf(buf, "1 0 0 1 %d %d Tm\r\n", r.x() + 3, wy - y);
			s += buf;
			y = y + h;
			s += "<";
			for (uint j = 0; j < t->lines[i].length(); ++j) {
				sprintf(buf, "%04X", (t->lines[i].at(j).unicode() & 0x0ffff));
				s += buf;
			}
			s += "> Tj\r\n";
		}
		s += "ET\r\n";
	} else {
		s += "q\r\n";
		if (elm->fill()) {
			sprintf(buf, "%f %f %f rg\r\n", r, g, b);
		} else {
			sprintf(buf, "%f %f %f RG\r\n", r, g, b);
		}
		s += buf;
		QPointArray points = elm->points().copy();
		points.translate(_origin.x(), _origin.y());
		if (elm->type() == FN_BEZIER) {
			sprintf(buf, "%d %d m\r\n", points[0].x(), wy - points[0].y());
			s += buf;
			for (uint j = 1; j < points.count(); j += 3) {
				sprintf(buf, "%d %d %d %d %d %d c\r\n",
					points[j].x(), wy - points[j].y(),
					points[j + 1].x(), wy - points[j + 1].y(),
					points[j + 2].x(), wy - points[j + 2].y()
					);
				s += buf;
			}
		} else if (elm->type() == FN_ELLIPSE) {
			int x = points[0].x();
			int y = points[0].y();
			int ex = points[1].x();
			int ey = points[1].y();
			int w = ex - x;
			int h = ey - y;
			int cx = x + w/2;
			int cy = y;
			int x1 = x + 3*w/4;
			int y1 = y;
			int x2 = x + w;
			int y2 = y + h/4;
			int x3 = x + w;
			int y3 = y + h/2;
			
			sprintf(buf, "%d %d m\r\n%d %d %d %d %d %d c\r\n", cx, wy - cy, x1, wy - y1, x2, wy - y2, x3, wy - y3);
			s += buf;
			x1 = x + w;
			y1 = y + 3 * h / 4;
			x2 = x + 3 * w / 4;
			y2 = y + h;
			x3 = x + w/2;
			y3 = y + h;
			sprintf(buf, "%d %d %d %d %d %d c\r\n", x1, wy - y1, x2, wy - y2, x3, wy - y3);
			s += buf;

			x1 = x + w / 4;
			y1 = y + h;
			x2 = x;
			y2 = y + 3 * h / 4;
			x3 = x;
			y3 = y + h / 2;
			sprintf(buf, "%d %d %d %d %d %d c\r\n", x1, wy - y1, x2, wy - y2, x3, wy - y3);
			s += buf;
			x1 = x;
			y1 = y + h / 4;
			x2 = x + w / 4;
			y2 = y;
			x3 = x + w / 2;
			y3 = y;
			sprintf(buf, "%d %d %d %d %d %d c\r\n", x1, wy - y1, x2, wy - y2, x3, wy - y3);
			s += buf;
		} else {
			sprintf(buf, "%d %d m\r\n", points[0].x(), wy - points[0].y());
			s += buf;
			for (uint j = 1; j < points.count(); ++j) {
				sprintf(buf, "%d %d l\r\n", points[j].x(), wy - points[j].y());
				s += buf;
			}
		}
		sprintf(buf, "%d w\r\n", elm->pen().width());
		s += buf;
		if (elm->fill()) {
			s += "f*\r\n";
		} else {
			s += "S\r\n";
		}
		s += "Q\r\n";
	}
	return s;
}

bool FNCanvas::exportPDF(const QFileInfo& info)
{
	if (0 == info.fileName().length()) {
		QMessageBox::warning(0,"FreeNoteQt", "file name is empty.");
		return false;
	}
	if (info.extension(false) != "pdf") {
		QMessageBox::warning(0,"FreeNoteQt", "extension '.pdf' expected.");
		return false;
	}

	FILE* fp = NULL;
	if (!(fp = fopen(info.absFilePath().utf8(), "wt"))) {
		QMessageBox::warning(0,"FreeNoteQt", "could not export file.");
		return false;
	}

	QPoint o = getTopLeft();
	rebuild();
	int wx = 595;
	int wy = 842;
	char buf[1024];
	int bias = 0;
	if (_isUseAllQuadrant) {
		bias = SNAP_SIZE;
	}
	for (uint l = 0; l < _layers.count(); ++l) {
		FNLayer& layer = *_layers.at(l);
		FNPolygonList& draws = layer.draws;
		for (uint i = 0; i < draws.count() - layer.disp_offset(); ++i) {
			FNPolygon* p = draws.at(i);
			QRect r = p->boundingRect();
			r.moveBy(_origin.x(), _origin.y());
			if (wx < r.right() + bias) {
				wx = r.right() + bias;
			}
			if (wy < r.bottom() + bias) {
				wy = r.bottom() + bias;
			}
		}
	}

	int len = 0;
	
	/*
	sprintf(buf, "1 0 0 -1 0 %d cm\r\n", wy);
	QString cm = buf;
	len += cm.length();
	*/
	QString cm = "";

	for (uint l = 0; l < _layers.count(); ++l) {
		FNLayer& layer = *_layers.at(l);
		if (layer.IsShow) {
			FNPolygonList& draws = layer.draws;
			for (uint i = 0; i < draws.count() - layer.disp_offset(); ++i) {
				QString s = mkPDFscript(draws.at(i), wy);
				len += s.length();
			}
		}
	}

	//int ref = 0;
	QString header = "";
	QStringList xref;
	xref.append("0000000000 65535 f\r\n");

	header += "%PDF-1.3\r\n";
	sprintf(buf, "%010d 00000 n\r\n", header.length());
	xref.append(buf);

	header += "1 0 obj<</Type/Catalog/Outlines 2 0 R/Pages 3 0 R>>\r\n";
	header += "endobj\r\n";
	sprintf(buf, "%010d 00000 n\r\n", header.length());
	xref.append(buf);


	header += "2 0 obj<</Type/Outlines/Count 0>>\r\n";
	header += "endobj\r\n";
	sprintf(buf, "%010d 00000 n\r\n", header.length());
	xref.append(buf);

	header += "3 0 obj<</Type/Pages/Kids[4 0 R]/Count 1>>\r\n";
	header += "endobj\r\n";
	sprintf(buf, "%010d 00000 n\r\n", header.length());
	xref.append(buf);

	header += "4 0 obj<</Type/Page/Parent 3 0 R";
	sprintf(buf, "/MediaBox[0 0 %d %d]", wx, wy);
	header += buf;
	header += "/Contents 6 0 R/Resources<</Font<</F1 5 0 R>>/ProcSet[/PDF/Text]>>>>\r\n";
	header += "endobj\r\n";
	sprintf(buf, "%010d 00000 n\r\n", header.length());
	xref.append(buf);

	if (encode == QString("WinAnsiEncoding")) {
		header += "5 0 obj<</Type/Font/Subtype/Type1/BaseFont/Helvetica/FirstChar 0/LastChar 255/Encoding/WinAnsiEncoding>>\r\n";
	} else if (encode == QString("UniJIS-UCS2-H")) {
		header += "5 0 obj<</Type/Font/Encoding/UniJIS-UCS2-H/BaseFont/MSGothic/Subtype/Type0/DescendantFonts[<</W[0[1000] 1 94 500 231 324 500 327 389 500 631 [500] 668 [500]]/Type/Font/BaseFont/MSGothic/Subtype/CIDFontType2/CIDSystemInfo<</Ordering(Japan1)/Registry(Adobe)/Supplement 2>>/FontDescriptor<</Type/FontDescriptor/FontBBox[0 -137 1000 859]/FontName/MSGothic/Flags 32/StemV 92/CapHeight 770/XHeight 543/Ascent 859/Descent -137/ItalicAngle 0>>/DW 1000>>]>>\r\n";
	}
	header += "endobj\r\n";
	sprintf(buf, "%010d 00000 n\r\n", header.length());
	xref.append(buf);

	sprintf(buf, "6 0 obj<</Length %d>>\r\n", len);
	header += buf;
	header += "stream\r\n";

	QString footer = "";
	footer += "xref\r\n";
	sprintf(buf, "0 %d\r\n", xref.count());
	footer += buf;
	for (uint i = 0; i < xref.count(); ++i) {
		footer += xref[i];
	}
	footer += "trailer\r\n";
	sprintf(buf, "<</Size %d/Root 1 0 R>>\r\n", xref.count());
	footer += buf;
	footer += "startxref\r\n";

	len = cm.length();
	len += header.length();
	fputs(header, fp);
	fputs(cm, fp);

	for (uint l = 0; l < _layers.count(); ++l) {
		FNLayer& layer = *_layers.at(l);
		if (layer.IsShow) {
			FNPolygonList& draws = layer.draws;
			for (uint i = 0; i < draws.count() - layer.disp_offset(); ++i) {
				QString s = mkPDFscript(draws.at(i), wy);
				len += s.length();
				fputs(s, fp);
			}
		}
	}
	QString streamfooter = "endstream\r\nendobj\r\n";
	len += streamfooter.length();
	fputs(streamfooter, fp);

	fputs(footer, fp);
	sprintf(buf, "%d\r\n", len);
	fputs(buf, fp);
	fputs("%%EOF\r\n", fp);
	fclose(fp);
	if (_isUseAllQuadrant) {
		setOrigin(-o.x(), -o.y());
	}
	FNMessageBox::information(0,"FreeNoteQt", "export PDF complete.");
	return true;
}

bool FNCanvas::save(const QFileInfo& info)
{
	if (0 == info.fileName().length()) {
		QMessageBox::warning(0,"FreeNoteQt", "file name is empty.");
		return false;
	}
	if (info.extension(false) != "free") {
		QMessageBox::warning(0,"FreeNoteQt", "extension '.free' expected.");
		return false;
	}
	FILE* fp = NULL;
	if (!(fp = fopen(info.absFilePath().utf8(), "wt"))) {
		QMessageBox::warning(0,"FreeNoteQt", "could not save file.");
		return false;
	}
	QPoint o = getTopLeft();
	rebuild();
	fputs("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n", fp);
	char buf[1024];
	sprintf(buf, "<freenote version=\"4.1\" pg=%d idx=\"%d\">\n", _isTinyPaging, _selIdx);
	fputs(buf, fp);
	for (uint l = 0; l < _layers.count(); ++l) {
		FNLayer& layer = *_layers.at(l);
		FNPolygonList& draws = layer.draws;
		QString s = "<layer v=";
		if (layer.IsShow) {
			s += "1 name=\"";
		} else {
			s += "0 name=\"";
		}
		s += layer.Name;
		s += "\">\n";
		fputs(s.utf8(), fp);
		for (uint i = 0; i < draws.count() - layer.disp_offset(); ++i) {
			FNPolygon p(*draws.at(i));
			p.translate(_origin.x(), _origin.y());
			if (p.type() == FN_BEZIER) {
				sprintf(buf, "\t<bz color=\"%x\" width=\"%d\" f=\"%d\">\n", (uint)p.pen().color().rgb(), p.pen().width(), p.fill());
			} else if (p.type() == FN_ELLIPSE) {
				sprintf(buf, "\t<el color=\"%x\" width=\"%d\" f=\"%d\">\n", (uint)p.pen().color().rgb(), p.pen().width(), p.fill());
			} else if (p.type() == FN_TEXT) {
				sprintf(buf, "\t<tx color=\"%x\" width=\"%d\">\n", (uint)p.pen().color().rgb(), p.pen().width());
			} else {
				sprintf(buf, "\t<po color=\"%x\" width=\"%d\" f=\"%d\">\n", (uint)p.pen().color().rgb(), p.pen().width(), p.fill());
			}
			fputs(buf, fp);
			QPointArray& points = p.points();
			for (uint j = 0; j < points.count(); ++j) {
				QPoint point = points.point(j);
				sprintf(buf, "\t\t<p x=\"%d\" y=\"%d\"/>\n", point.x(), point.y());
				fputs(buf, fp);
			}
			if (p.type() == FN_BEZIER) {
				fputs("\t</bz>\n", fp);
			} else if (p.type() == FN_ELLIPSE) {
				fputs("\t</el>\n", fp);
			} else if (p.type() == FN_TEXT) {
				FNText* tp = (FNText*)draws.at(i);
				for (uint j = 0; j < tp->lines.count(); ++j) {
					s = "\t\t<t v=\"";
					s += tp->lines[j];
					s += "\"/>\n";
					fputs(s.utf8(), fp);
				}
				fputs("\t</tx>\n", fp);
			} else {
				fputs("\t</po>\n", fp);
			}
		}
		fputs("</layer>\n", fp);
	}
	fputs("</freenote>\n", fp);
	fclose(fp);
	if (_isUseAllQuadrant) {
		setOrigin(-o.x()+SNAP_SIZE, -o.y()+SNAP_SIZE);
	}
	FNMessageBox::information(0, "FreeNoteQt", "save complete.");
	return true;
}

bool FNCanvas::load(const QFileInfo& info)
{
	if (0 == info.fileName().length()) {
		QMessageBox::warning(0,"FreeNoteQt", "file name is empty.");
		return false;
	}
	if (!info.exists()) {
		QMessageBox::warning(0,"FreeNoteQt", "file not exists.");
		return false;
	}
	FILE* fp = NULL;
	if (!(fp = fopen(info.absFilePath().utf8(), "rt"))) {
		QMessageBox::warning(0,"FreeNoteQt", "could not open file.");
		return false;
	}
	clear();
	open(_layers, fp);
	if ((uint)_selIdx >= _layers.count()) {
		_selIdx = 0;
	}
	_current = _layers.at(_selIdx);
	fclose(fp);

	redraw();
	FNMessageBox::information(0,"FreeNoteQt", "load complete.");

	return true;
}

bool FNCanvas::import(const QFileInfo& info)
{
	if (0 == info.fileName().length()) {
		QMessageBox::warning(0,"FreeNoteQt", "file name is empty.");
		return false;
	}
	if (!info.exists()) {
		QMessageBox::warning(0,"FreeNoteQt", "file not exists.");
		return false;
	}
	FILE* fp = NULL;
	if (!(fp = fopen(info.absFilePath().utf8(), "rt"))) {
		QMessageBox::warning(0,"FreeNoteQt", "could not open file.");
		return false;
	}
	clearList(_clipboard);
	open(_clipboard, fp);
	fclose(fp);
	if (0 < _clipboard.count()) {
		int x = _clipboard.at(0)->boundingRect().left();
		int y = _clipboard.at(0)->boundingRect().top();
		for (uint i = 1; i < _clipboard.count(); ++i) {
			if (y > _clipboard.at(i)->boundingRect().top()) {
				y = _clipboard.at(i)->boundingRect().top();
			}
			if (x > _clipboard.at(i)->boundingRect().left()) {
				x = _clipboard.at(i)->boundingRect().left();
			}
		}
		for (uint i = 0; i < _clipboard.count(); ++i) {
			_clipboard.at(i)->translate(-x, -y);
		}
	}
	FNMessageBox::information(0,"FreeNoteQt", "import complete.");

	return true;
}
void FNCanvas::open(FNPolygonList& list, FILE* fp)
{
	clearList(list);
	FNLayerList layers;
	open(layers, fp);
	for (uint i = 0; i < layers.count(); ++i) {
		FNLayer& layer = *layers.at(i);
		if (layer.IsShow) {
			layer.draws.clone(list);
			/*
			FNPolygonList& elmlst = layer.draws;
			for (uint j = 0; j < elmlst.count(); ++j) {
				list.append(elmlst.at(j));
			}
			elmlst.clear();
			*/
		}
	}
	layers.clear();
}

void FNCanvas::open(FNLayerList& layers, FILE* fp)
{
	QString line;
	FNPointList points;
	points.setAutoDelete(true);
	int c;
	int w;
	QPen pen(Qt::black, 1);
	FNPolygon* polygon;
	
	char rdbuf[1024];
	char buf[1024];
	QString type = "";
	QStringList lines;
	layers.setAutoDelete(true);
	layers.clear();
	layers.setAutoDelete(false);
	FNLayer* layer = new FNLayer();
	layer->IsShow = true;
	layer->Name = "Layer0";
	//_current = layer;
	layers.append(layer);
	FNPolygonList* list = &layer->draws;
	bool isFirstLayer = true;
	bool fill = false;
	while (!feof(fp)) {
		fgets(rdbuf, sizeof(rdbuf), fp);
		line = rdbuf;
		if (-1 != line.find("<freenote")) {
			if (-1 != line.find("pg=1")) {
				_isTinyPaging = true;
			} else {
				_isTinyPaging = false;
			}
			int st = line.find("idx=") + 5;
			int ed = line.find("\"", st);
			strcpy(buf, line.mid(st, ed - st));
			sscanf(buf, "%d", &_selIdx);
		} else if (-1 != line.find("<layer ")) {
			if (false == isFirstLayer) {
				layer = new FNLayer();
				list = &layer->draws;
				layers.append(layer);
			}
			isFirstLayer = false;

			if (-1 != line.find("v=0")) {
				layer->IsShow = false;
			} else if (-1 != line.find("v=1")) {
				layer->IsShow = true;
			}
			int st = line.find("name=") + 6;
			int ed = line.find("\"", st);
			strcpy(buf, line.mid(st, ed - st));
			QTextCodec *codec = QTextCodec::codecForName("utf8");
			layer->Name = codec->toUnicode(buf);
		} else if (-1 != line.find("<fnpolygon ") ||
			-1 != line.find("<po ") ||
			-1 != line.find("<bz ") ||
			-1 != line.find("<el ") ||
			-1 != line.find("<tx ")
		) {
			if (-1 != line.find("<el ")) {
				type = "Ellipse";
			} else if (-1 != line.find("<bz ")) {
				type = "Bezier";
			} else if (-1 != line.find("<tx ")) {
				type = "Text";
				lines.clear();
			} else {
				type = "Polygon";
			}
			fill = false;
			points.clear();
			int st = line.find("color") + 7;
			int ed = line.find("\"", st);
			strcpy(buf, line.mid(st, ed - st));
			sscanf(buf, "%x", &c);

			st = line.find("width") + 7;
			ed = line.find("\"", st);
			strcpy(buf, line.mid(st, ed - st));
			sscanf(buf, "%d", &w);
			
			if (-1 != line.find(" f=\"1\"")) {
				fill = true;
			}
		} else if (-1 != line.find("<point ") ||
			-1 != line.find("<p ")
			) {
			int st = line.find("x=") + 3;
			int ed = line.find("\"", st);
			strcpy(buf, line.mid(st, ed - st));
			int x;
			sscanf(buf, "%d", &x);

			st = line.find("y=") + 3;
			ed = line.find("\"", st);
			strcpy(buf, line.mid(st, ed - st));
			int y;
			sscanf(buf, "%d", &y);
			points.append(createPts(x, y)); //バグ対策
		} else if (-1 != line.find("<t ")) {
			int st = line.find("v=") + 3;
			int ed = line.findRev("\"");
			strcpy(buf, line.mid(st, ed - st));
			QTextCodec *codec = QTextCodec::codecForName("utf8");
			lines.append(codec->toUnicode(buf));
		} else if (-1 != line.find("</fnpolygon") || 
			-1 != line.find("</bz") ||
			-1 != line.find("</el") ||
			-1 != line.find("</po") ||
			-1 != line.find("</tx")) {
			pen.setColor((QRgb)c);
			pen.setWidth(w);
			if (type == "Bezier") {
				list->append(polygon = createBezier(pen)); //バグ対策
			} else if (type == "Ellipse") {
				list->append(polygon = createEllipse(pen)); //バグ対策
			} else if (type == "Text") {
				list->append(polygon = createText(pen, lines));
			} else {
				list->append(polygon = createPolygon(pen)); //バグ対策
			}
			polygon->setFill(fill);
			polygon->setPoints(points);
			points.clear();
		}
	}
}

FNPolygon* FNCanvas::createPolygon(QPen& pen)
{
	return new FNPolygon(pen);
}

FNPolygon* FNCanvas::createBezier(QPen& pen)
{
	return new FNBezier(pen);
}


FNPolygon* FNCanvas::createEllipse(QPen& pen)
{
	return new FNEllipse(pen);
}

FNPolygon* FNCanvas::createText(QPen& pen, QStringList& lines)
{
	FNText* p = new FNText(pen);
	p->lines = lines;
	return p;
}

QPoint* FNCanvas::createPts(int x, int y) 
{
	return new QPoint(x, y);
}

void FNCanvas::setGuide(bool f)
{
	_isShowGuide = f;
	redraw();
}

void FNCanvas::fillChanged(bool f) {
	_fill = f;
	if (_isSelected) {
		for (uint i = 0; i < _selected.count(); ++i) {
			_selected.at(i)->setFill(f);
		}
	}
}
