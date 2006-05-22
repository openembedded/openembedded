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

2005/01/09 FNViewer ジェスチャー用ロジック追加
2004/10/17 FreeNote 1.10.0リリース
2003/12/16-19 FreeNote ver 1.5.5pre
・曲線描画ロジックの改良

2003/12/14 FreeNote 1.5.4pre
・曲線描画ロジックの改良

2003/11/30-2003/12/04 FreeNote 1.5.3pre
・ベジェ関数のスペルミスを修正

2003/11/16 FreeNote 1.5.2pre
・円描画のロジックを追加

2003/11/13 FreeNote 1.5.1pre
・スムージング追加
2003/11/10-12
・曲線整形モード追加
2003/11/09 追加
*/
#include "fmtengine.h"
#include <qpointarray.h>
#include <qpe/qmath.h>
#include <math.h>
#include <qrect.h>
#include <stdlib.h>

int SNAP_SIZE = 32;
int PHASE1_ANGLE = 30;
int PHASE2_ANGLE = 30;
double Surface(const QPoint& p1, const QPoint& p2)
{
	return 0.5 * abs(p1.x() * p2.y() - p1.y() * p2.x());
}

bool IsLinear(const QPoint& p1, const QPoint& p2, const QPoint& p3)
{
	double s1 = Surface(p1, p2);
	double s2 = Surface(p2, p3);
	double s3 = Surface(p1, p3);
	if (s1 + s2 == s3) {
		return true;
	} else {
		return false;
	}
}

const double Angle(const QPoint& p1, const QPoint& p2)
{
	return qATan2((double)(p2.y() - p1.y()), (double)(p2.x() - p1.x()));
}

const double DiffAngle(double a1, double a2)
{
	if (0.0 > a1) {
		a1 = 2 * M_PI + a1;
	}
	if (0.0 > a2) {
		a2 = 2 * M_PI + a2;
	}
	return fabs(a1 - a2);
}

const double DiffAngle2(double a1, double a2)
{
	if (0.0 > a1) {
		a1 = 360 + a1;
	}
	if (0.0 > a2) {
		a2 = 360 + a2;
	}
	return fabs(a1 - a2);
}

const double DiffAngle(const QPoint& p1, const QPoint& p2, const QPoint& p3)
{
	return DiffAngle(Angle(p1, p2), Angle(p2, p3));
}

const double ToDegree(double t)
{
	return t * 180 / M_PI;
}

const double ToRadian(double d)
{
	return d * M_PI / 180;
}

const double Distance(const QPoint& p1, const QPoint& p2)
{
	return hypot(p1.x() - p2.x(), p1.y() - p2.y());
}

const QPoint SnapPoint(const QPoint& p, int snap)
{
	int x = ((int)(p.x() + snap / 2) / snap) * snap;
	int y = ((int)(p.y() + snap / 2) / snap) * snap;
	return QPoint(x, y);
}
const QPoint SnapPoint(const QPoint& p)
{
	return SnapPoint(p, SNAP_SIZE);
}
/*
const QPoint SnapPoint(const QPoint& p)
{
	int x = ((int)(p.x() + SNAP_SIZE / 2) / SNAP_SIZE) * SNAP_SIZE;
	int y = ((int)(p.y() + SNAP_SIZE / 2) / SNAP_SIZE) * SNAP_SIZE;
	return QPoint(x, y);
}
*/

const QPoint ArrangePoint(const QPoint& p1, const QPoint& p2)
{
	int x = p2.x();
	int y = p2.y();
	if (p1.x() - SNAP_SIZE / 2 <= x && p1.x() + SNAP_SIZE / 2 >= x) {
		x = p1.x();
	}
	if (p1.y() - SNAP_SIZE / 2 <= y && p1.y() + SNAP_SIZE / 2 >= y) {
		y = p1.y();
	}
	return QPoint(x, y);
}

FNPointList ReducePoints(FNPointList& p)
{
	if (2 >= p.count()) {
		return p;
	}
	FNPointList rt;
	rt.append(p.first());
	QPoint* p1 = p.first();
	QPoint* p2 = p.at(1);
	QPoint* p3 = NULL;
	for (uint i = 2; i < p.count(); ++i) {
		p3 = p.at(i);
		if (false == IsLinear(*p1, *p2, *p3)) {
			rt.append(p2);
			p1 = p2;
		}
		p2 = p3;
	}
	rt.append(p3);
	return rt;
}

FNPointList ExtractAngle2(FNPointList& p, const int deg)
{
	FNPointList rt;
	rt.append(p.first());
	QPoint* st = p.first();
	QPoint* mp = p.at(1);
	QPoint* ed = p.last();
	for (uint i = 2; i < p.count(); ++i) {
		ed = p.at(i);
		if (ToRadian(deg) <= DiffAngle(*st, *mp, *ed)) {
			st = mp;
			rt.append(mp);
		}
		mp = ed;
	}
	rt.append(ed);
	return rt;
}

FNPointList ExtractAngle(FNPointList& p, const int deg)
{
	FNPointList rt;
	rt.append(p.first());
	QPoint* st = p.first();
	QPoint* mp = p.at(1);
	QPoint* ed = p.last();
	for (uint i = 2; i < p.count(); ++i) {
		ed = p.at(i);
		if (ToRadian(deg) <= DiffAngle(*st, *mp, *ed)) {
			st = mp;
			rt.append(mp); 
		}
		mp = ed;
	}
	if (SNAP_SIZE / 2 > Distance(*p.first(), *p.last()) && 3 < p.count()) {
		rt.append(p.first());
	} else {
		rt.append(ed);
	}
	return rt;
}

FNPointList SumupPoints(FNPointList& p)
{
	if (3 >= p.count()) {
		return p;
	}
	FNPointList rt;
	rt.append(p.first());
	QPoint* p1 = p.first();
	QPoint* p2 = NULL;
	double pred = 0;
	for (uint i = 1; i < p.count() - 1; ++i) {
		p2 = p.at(i);
		double d = Distance(*p1, *p2);
		if (SNAP_SIZE / 2 < d || pred > d) {
			rt.append(p2);
			p1 = p2;
			d = 0;
		}
		pred = d;
	}
	rt.append(p.last());
	return rt;
}

FNPointList SnapPoints(FNPointList& p)
{
	FNPointList rt;
	for (uint i = 0; i < p.count(); ++i) {
		QPoint tp = SnapPoint(*p.at(i));
		p.at(i)->setX(tp.x());
		p.at(i)->setY(tp.y());
		rt.append(p.at(i));
	}
	return rt;
}

FNPointList ArrangePoints(FNPointList& p)
{
	if (3 >= p.count() && 2 != p.count()) {
		return p;
	}
	FNPointList rt;
	rt.append(p.first());
	QPoint* p1 = p.first();
	QPoint* p2 = NULL;
	for (uint i = 1; i < p.count(); ++i) {
		p2 = p.at(i);
		QPoint tp = ArrangePoint(*p1, *p2);
		p2->setX(tp.x());
		p2->setY(tp.y());
		rt.append(p2);
		p1 = p2;
	}
	if (*p.first() == *p.last()) {
		QPoint tp = ArrangePoint(*p1, *p.first());
		rt.first()->setX(tp.x());
		rt.first()->setY(tp.y());
	}
	return rt;
}

FNPointList TuningPoints(FNPointList& p)
{
	FNPointList rt;
	if (3 >= p.count()) {
		for (uint i = 0; i < p.count(); ++i) {
			rt.append(new QPoint(*p.at(i)));
		}
		return rt;
	}
	rt.append(new QPoint(*p.at(0)));
	for (uint i = 1; i < p.count() - 1; ++i) {
		QPoint* p1 = p.at(i);
		QPoint* p2 = p.at(i + 1);
		rt.append(new QPoint(*p1));
		if (i < p.count() - 2) {
			rt.append(new QPoint((p1->x() + p2->x())/2, (p1->y() + p2->y())/2));
		}
	}
	rt.append(new QPoint(*p.at(p.count()-1)));
	return rt;
}

FNPointList ToBezier(FNPointList& p) {
	FNPointList rt;
	rt.append(new QPoint(*p.at(0)));
	for (uint i = 0; i < p.count() - 2; i += 2) {
		int x1 = p.at(i)->x();
		int xa = p.at(i + 1)->x();
		int x4 = p.at(i + 2)->x();

		int x2 = (x1 + xa) / 2;
		int x3 = (xa + x4) / 2;
		
		int y1 = p.at(i)->y();
		int ya = p.at(i + 1)->y();
		int y4 = p.at(i + 2)->y();

		int y2 = (y1 + ya) / 2;
		int y3 = (ya + y4) / 2;
		
		rt.append(new QPoint(x2 ,y2));
		rt.append(new QPoint(x3 ,y3));
		rt.append(new QPoint(x4 ,y4));
	}
	return rt;
}

FNPointList ToCurves(FNPointList& p) {
	if (3 <= p.count()) {
		//ベジェによる補完 
		return ToBezier(p);
	} else {
		FNPointList rt;
		for (uint i = 0; i < p.count(); ++i) {
			rt.append(new QPoint(*p.at(i)));
		}
		return rt;
	}
}

FNPointList AutoFormat(FNPointList& p)
{
	FNPointList tp = ExtractAngle(p, PHASE1_ANGLE);
	uint n;
	do {
		n = tp.count();
		tp = SumupPoints(tp);
		tp = ExtractAngle(tp, PHASE1_ANGLE);
		tp = ArrangePoints(tp);
	} while (n > tp.count());
	tp = SnapPoints(tp);
	tp = ReducePoints(tp);
	FNPointList rt;
	if (2 == tp.count()) {
		if (*tp.first() == *tp.last()) {
			return rt;
		}
	}
	for (uint i = 0; i < tp.count(); ++i) {
		rt.append(new QPoint(*tp.at(i)));
	}
	return rt;
}

FNPointList ToEllipse(int x, int y, int w, int h) {
	FNPointList rt;
	QPointArray pa;
	pa.makeEllipse(x, y, w, h);
	for (uint i = 0; i < pa.count(); ++i) {
		rt.append(new QPoint(pa.point(i)));
	}
	return rt;
}

FNPointList AutoCurve(FNPointList& p)
{
	FNPointList tp2;
	tp2.setAutoDelete(true); 
	FNPointList tp4;
	tp4.setAutoDelete(true); 
	/*
	QPoint sp = SnapPoint(*p.at(0));
	QPoint ep = SnapPoint(*p.at(p.count()-1));
	if (sp == ep) {
		//楕円
		int sx = p.at(0)->x();
		int sy = p.at(0)->y();
		int ex = sx;
		int ey = sy;
		for (uint i = 1; i < p.count(); ++i) {
			QPoint tp = *p.at(i);
			if (sx > tp.x()) {
				sx = tp.x();
			} else if (ex < tp.x()) {
				ex = tp.x();
			}
			if (sy > tp.y()) {
				sy = tp.y();
			} else if (ey < tp.y()) {
				ey = tp.y();
			}
		}
		sp = SnapPoint(QPoint(sx, sy));
		ep = SnapPoint(QPoint(ex, ey));
		tp2.append(new QPoint(sp.x(), sp.y()));
		tp2.append(new QPoint(ep.x(), ep.y()));
	} else {
		*/
		FNPointList tp = ExtractAngle2(p, PHASE2_ANGLE);
		uint n;
		do {
			n = tp.count();
			tp = SumupPoints(tp);
			tp = ExtractAngle2(tp, PHASE2_ANGLE);
			tp = SnapPoints(tp);
		} while (n > tp.count());
		tp = SumupPoints(tp);
		tp = ReducePoints(tp);
		tp4 = TuningPoints(tp);
		tp2 = ToCurves(tp4);
	//}
	FNPointList rt;
	if (2 == tp2.count()) {
		if (*tp2.first() == *tp2.last()) { 
			return rt;
		}
	}
	for (uint i = 0; i < tp2.count(); ++i) {
		rt.append(new QPoint(*tp2.at(i))); 
	}
	return rt;
}

FNPointList Smoothing(FNPointList& p)
{
	int tsnap = SNAP_SIZE;
	SNAP_SIZE=8;
	FNPointList tp = ExtractAngle2(p,  PHASE2_ANGLE);
	tp = SumupPoints(tp);
	tp = ReducePoints(tp);
	FNPointList tp4 = TuningPoints(tp);
	tp4.setAutoDelete(true);
	FNPointList tp2 = ToCurves(tp4);
	tp2.setAutoDelete(true);
	FNPointList rt;
	for (uint i = 0; i < tp2.count(); ++i) {
		rt.append(new QPoint(*tp2.at(i))); 
	}
	SNAP_SIZE = tsnap;
	return rt;
}

FNPointList Reduce(FNPointList& p)
{
	FNPointList tp = ReducePoints(p);
	FNPointList rt;
	for (uint i = 0; i < tp.count(); ++i) {
		rt.append(new QPoint(*tp.at(i))); 
	}
	return rt;
}

QRect GetBounds(FNPointList& v)
{
	if (1 > v.count()) {
		return QRect(0, 0, 1, 1);
	}
	QPoint sp = *v.at(0);
	QPoint ep = sp;
	for (uint i = 1; i < v.count(); ++i) {
		QPoint& p = *v.at(i);
		if (sp.x() > p.x()) {
			sp.setX(p.x());
		}
		if (sp.y() > p.y()) {
			sp.setY(p.y());
		}
		if (ep.x() < p.x()) {
			ep.setX(p.x());
		}
		if (ep.y() < p.y()) {
			ep.setY(p.y());
		}
	}
	return QRect(sp, ep);
}

FNPointList Translate(FNPointList& v, int x, int y, double xs, double ys)
{
	FNPointList rt;
	for (uint i = 0; i < v.count(); ++i) {
		QPoint& p = *v.at(i);
		int X = (int)((p.x() - x) * xs);
		int Y = (int)((p.y() - y) * ys);
		rt.append(new QPoint(X, Y));
	}
	return rt;
}

double ToStrokeDeg(double v)
{
	double d = ((int)(v * 10 / 225)) * 22.5;
	return d;
}

int sign(int v)
{
	if (0 > v) {
		return -1;
	} else if (0 < v) {
		return 1;
	} else {
		return 0;
	}
};

