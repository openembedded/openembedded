# eel OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

inherit gnome
PR = "r2"

LICENSE="GPL"
SRC_URI += "file://configure.patch;patch=1"

DEPENDS="libgnomeui virtual/gail"
EXTRA_OECONF = "--disable-gtk-doc"

edir="${STAGING_INCDIR}/eel-2/eel"

headers="eel-accessibility.h              eel-graphic-effects.h \
	eel-alert-dialog.h               eel-gtk-container.h \
	eel-art-extensions.h             eel-gtk-extensions.h \
	eel-art-gtk-extensions.h         eel-gtk-macros.h \
	eel-background-box.h             eel-i18n.h \
	eel-background.h                 eel-image-table.h \
	eel-canvas-rect-ellipse.h        eel-labeled-image.h \
	eel-canvas-util.h                eel-marshal.h \
	eel-canvas.h                     eel-pango-extensions.h \
	eel-cell-renderer-pixbuf-list.h  eel-preferences-glade.h \
	eel-dateedit-extensions.h        eel-preferences.h \
	eel-debug-drawing.h              eel-self-checks.h \
	eel-debug.h                      eel-stock-dialogs.h \
	eel-editable-label.h             eel-string-list.h \
	eel-ellipsizing-label.h          eel-string.h \
	eel-enumeration.h                eel-type-builtins.h \
	eel-features.h                   eel-types.h \
	eel-gconf-extensions.h           eel-vfs-extensions.h \
	eel-gdk-extensions.h             eel-wrap-table.h \
	eel-gdk-pixbuf-extensions.h      eel-xml-extensions.h \
	eel-glib-extensions.h            eel.h \
	eel-gnome-extensions.h"

do_stage() {
	install -d ${edir}
	for file in ${headers}; do
		install -m 0644 eel/$file ${edir}/$file
	done

	oe_libinstall -C eel libeel-2 ${STAGING_LIBDIR}
}

SRC_URI[archive.md5sum] = "6dd46ef1905271cd1171a0bdddabee22"
SRC_URI[archive.sha256sum] = "889c8cff395bc488a6ccfb3fc22fd241a12c33f114bb7d7ec4138d5999da9c5d"
