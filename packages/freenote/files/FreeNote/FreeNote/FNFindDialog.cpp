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

2005/01/04 FreeNote 1.11.6pre
・カーブモードで８の字がかけるように整形エンジンを改善

2004/10/17 FreeNote 1.10.0リリース
2004/02/14 ver 1.7.2pre
・検索機能の追加
*/
#include "fnfinddialog.h"
#include "fmtengine.h"
#include <qlineedit.h>
#include <stdio.h>
#include <qregexp.h>
#include <qcheckbox.h>

FNFindDialog::FNFindDialog( QWidget* parent, const char* name)
	:FNFindDialogBase(parent, name, true, 0), _idx(0)
{
}

void FNFindDialog::setElements(FNLayerList& v)
{
	_texts.clear();
	for (uint i = 0; i < v.count(); ++i) {
		FNLayer& layer = *v.at(i);
		if (layer.IsShow) {
			FNPolygonList& draws = layer.draws;
			for (uint j = 0; j < draws.count(); ++j) {
				FNPolygon* p = draws.at(j);
				if (FN_TEXT == p->type()) {
					_texts.append(p);
				}
			}
		}
	}
	_idx = -1;
}

void FNFindDialog::findPrev()
{
	QString sch = txtSearch->text();
	QRegExp rex(sch);
	if (0 == sch.length()) {
		return;
	}
	if (0 > _idx) {
		_idx = _texts.count() - 1;
	}
	if ((uint)_idx >= _texts.count()) {
		_idx = _texts.count() - 1;
	}
	for (; _idx >= 0; --_idx) {
		FNText* p = (FNText*)_texts.at(_idx);
		for (uint i = 0; i < p->lines.count(); ++i) {
			if (ckbIsRegExp->isChecked()) {
				for (uint i = 0; i < p->lines.count(); ++i) {
					if (-1 != p->lines[i].find(rex)) {
						emit resetOrigin();
						QPoint sp = p->points().point(0);
						emit originChanged(sp.x() - SNAP_SIZE, sp.y() - SNAP_SIZE);
						--_idx;
						return;
					}
				}
			} else {
				for (uint i = 0; i < p->lines.count(); ++i) {
					if (-1 != p->lines[i].find(sch)) {
						emit resetOrigin();
						QPoint sp = p->points().point(0);
						emit originChanged(sp.x() - SNAP_SIZE, sp.y() - SNAP_SIZE);
						--_idx;
						return;
					}
				}
			}
		}
	}
}

void FNFindDialog::findNext()
{
	QString sch = txtSearch->text();
	QRegExp rex(sch);
	if (0 == sch.length()) {
		return;
	}
	if (0 > _idx) {
		_idx = 0;
	}
	if ((uint)_idx >= _texts.count()) {
		_idx = 0;
	}
	for (; (uint)_idx < _texts.count(); ++_idx) {
		FNText* p = (FNText*)_texts.at(_idx);
		if (ckbIsRegExp->isChecked()) {
			for (uint i = 0; i < p->lines.count(); ++i) {
				if (-1 != p->lines[i].find(rex)) {
					emit resetOrigin();
					QPoint sp = p->points().point(0);
					emit originChanged(sp.x() - SNAP_SIZE, sp.y() - SNAP_SIZE);
					++_idx;
					return;
				}
			}
		} else {
			for (uint i = 0; i < p->lines.count(); ++i) {
				if (-1 != p->lines[i].find(sch)) {
					emit resetOrigin();
					QPoint sp = p->points().point(0);
					emit originChanged(sp.x() - SNAP_SIZE, sp.y() - SNAP_SIZE);
					++_idx;
					return;
				}
			}
		}
	}
}


FNFindDialog::~FNFindDialog()
{
}
