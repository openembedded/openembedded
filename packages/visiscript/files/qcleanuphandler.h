/****************************************************************************
** $Id: qt/qcleanuphandler.h   3.3.3   edited May 27 2003 $
**
** ...
**
** Copyright (C) 2001-2002 Trolltech AS.  All rights reserved.
**
** This file is part of the tools module of the Qt GUI Toolkit.
**
** This file may be distributed under the terms of the Q Public License
** as defined by Trolltech AS of Norway and appearing in the file
** LICENSE.QPL included in the packaging of this file.
**
** This file may be distributed and/or modified under the terms of the
** GNU General Public License version 2 as published by the Free Software
** Foundation and appearing in the file LICENSE.GPL included in the
** packaging of this file.
**
** Licensees holding valid Qt Enterprise Edition or Qt Professional Edition
** licenses may use this file in accordance with the Qt Commercial License
** Agreement provided with the Software.
**
** This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE
** WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
**
** See http://www.trolltech.com/pricing.html or email sales@trolltech.com for
**   information about Qt Commercial License Agreements.
** See http://www.trolltech.com/qpl/ for QPL licensing information.
** See http://www.trolltech.com/gpl/ for GPL licensing information.
**
** Contact info@trolltech.com if any conditions of this licensing are
** not clear to you.
**
**********************************************************************/

#ifndef QCLEANUPHANDLER_H
#define QCLEANUPHANDLER_H

#ifndef QT_H
#include "qptrlist.h"
#endif // QT_H

template<class Type>
class QCleanupHandler
{
public:
    QCleanupHandler() : cleanupObjects( 0 ) {}
    ~QCleanupHandler() { clear(); }

    Type* add( Type **object ) {
	if ( !cleanupObjects )
	    cleanupObjects = new QPtrList<Type*>;
	cleanupObjects->insert( 0, object );
	return *object;
    }

    void remove( Type **object ) {
	if ( !cleanupObjects )
	    return;
	if ( cleanupObjects->findRef( object ) >= 0 )
	    (void) cleanupObjects->take();
    }

    bool isEmpty() const {
	return cleanupObjects ? cleanupObjects->isEmpty() : TRUE;
    }

    void clear() {
	if ( !cleanupObjects )
	    return;
	QPtrListIterator<Type*> it( *cleanupObjects );
	Type **object;
	while ( ( object = it.current() ) ) {
	    delete *object;
	    *object = 0;
	    cleanupObjects->remove( object );
	}
	delete cleanupObjects;
	cleanupObjects = 0;
    }

private:
    QPtrList<Type*> *cleanupObjects;
};

template<class Type>
class QSingleCleanupHandler
{
public:
    QSingleCleanupHandler() : object( 0 ) {}
    ~QSingleCleanupHandler() {
	if ( object ) {
	    delete *object;
	    *object = 0;
	}
    }
    Type* set( Type **o ) {
	object = o;
	return *object;
    }
    void reset() { object = 0; }
private:
    Type **object;
};

template<class Type>
class QSharedCleanupHandler
{
public:
    QSharedCleanupHandler() : object( 0 ) {}
    ~QSharedCleanupHandler() {
	if ( object ) {
	    if ( (*object)->deref() )
		delete *object;
	    *object = 0;
	}
    }
    Type* set( Type **o ) {
	object = o;
	return *object;
    }
    void reset() { object = 0; }
private:
    Type **object;
};

#endif //QCLEANUPHANDLER_H
