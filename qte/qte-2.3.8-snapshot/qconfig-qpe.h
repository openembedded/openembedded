/**********************************************************************
** Copyright (C) 2000-2004 Trolltech AS.  All rights reserved.
**
** This file is part of the Qtopia Environment.
**
** Licensees holding a valid license agreement from Trolltech or any of its
** authorized distributors may use this file in accordance with
** the License Agreement provided with the Licensed Software.
**
** This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING THE
** WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.
**
** See http://www.trolltech.com/pricing.html or email sales.com for
**   information about Trolltech's Commercial License Agreements.
**
** Contact info.com if any conditions of this licensing are
** not clear to you.
**
**********************************************************************/
#ifndef QT_H
#endif // QT_H

// Note that disabling more features will produce a libqte that is not
// compatible with other libqte builds.

#ifndef QT_DLL
#define QT_DLL // Internal
#endif

// Qtopia Phone
#if defined(QTOPIA_PHONE)
# if !defined(QT_KEYPAD_INPUT)
#  define QT_KEYPAD_INPUT
# endif
#endif

// Platforms where mouse cursor is never required.
#if defined(QT_QWS_IPAQ) || defined(QT_QWS_CASSIOPEIA) || defined(QT_QWS_SL5XXX) || defined(QT_KEYPAD_MODE)
# define QT_NO_QWS_CURSOR
# define QT_NO_QWS_MOUSE_AUTO
#endif

// No builtin codecs (Qtopia uses plugins to add codecs individually)
#ifndef QT_NO_CODECS
#define QT_NO_CODECS
#endif

// No builtin font factories (Qtopia uses plugins)
#define QT_NO_FREETYPE
#define QT_NO_BDF

// No builtin styles (Qtopia uses plugins)
#define QT_NO_STYLE_POCKETPC
#ifndef QT_NO_STYLE_AQUA
# define QT_NO_STYLE_AQUA
#endif
#define QT_NO_STYLE_MOTIF
#define QT_NO_STYLE_PLATINUM

// No builtin WM styles (Qtopia uses plugins)
#define QT_NO_QWS_BEOS_WM_STYLE
#define QT_NO_QWS_KDE2_WM_STYLE
#define QT_NO_QWS_KDE_WM_STYLE
#define QT_NO_QWS_WINDOWS_WM_STYLE

// Space savings: disable expensive features
#define QT_NO_UNICODETABLES
#ifndef QT_NO_IMAGEIO_MNG
# define QT_NO_IMAGEIO_MNG
#endif
#define QT_NO_PROPERTIES
#define QT_NO_COLORNAMES

// Space savings: features insufficiently useful on handheld device
#define QT_NO_IMAGEIO_PPM
#define QT_NO_NETWORKPROTOCOL
#define QT_NO_PICTURE
#define QT_NO_PRINTER
#define QT_NO_QWS_SAVEFONTS

// Space savings: features impractical on small display
#define QT_NO_COLORDIALOG
#define QT_NO_FILEDIALOG
#define QT_NO_FONTDIALOG

// Space savings: features impractical on stylus device
#define QT_NO_DIAL
#define QT_NO_DRAGANDDROP
#define QT_NO_IMAGE_TEXT
#define QT_NO_INPUTDIALOG
#define QT_NO_PRINTDIALOG
#define QT_NO_PROGRESSDIALOG
#define QT_NO_SEMIMODAL
#define QT_NO_SIZEGRIP
#define QT_NO_SPLITTER
#define QT_NO_WORKSPACE

// Speed savings: features that incur unacceptable performance penalty
#define QT_NO_DOM
#define QT_NO_EFFECTS
#define QT_NO_TRANSFORMATIONS

// Qt 3 features (not relevant at this time)
#define QT_NO_TRANSLATION_BUILDER
#define QT_NO_COMPLEXTEXT

// Features included directly in Qtopia
#if !(defined (_OS_WIN32_) || defined (_WS_WIN32_))
#define QT_NO_WIZARD_IMPL
#endif

// Features for Qtopia under Win32 SDK
#if defined (_OS_WIN32_) || defined (_WS_WIN32_)
#define QT_NO_PRINTER
#define QT_NO_QWS_LINUXFB
#define QT_NO_QWS_MACH64
#define QT_NO_QWS_VOODOO3
#define QT_NO_QWS_MATROX
#define QT_NO_QWS_VNC
#define QT_NO_QWS_TRANSFORMED
#define QT_NO_QWS_VGA_16
#define QT_NO_QWS_SVGALIB
#endif
#define QT_NO_QMEMORYFILE
