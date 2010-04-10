# nautilus OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

inherit gnome
LICENSE="GPL"

DEPENDS="librsvg eel esound gnome-desktop"

EXTRA_OECONF = "--disable-gtk-doc"

PACKAGES += "libnautilus"

FILES_${PN} = "/usr/bin/* /usr/libexec/* /usr/lib/bonobo/* /usr/share/* /etc/*"
FILES_libnautilus = "/usr/lib/*.so*"

libnheaders="libnautilus.h                   nautilus-undo-private.h \
	nautilus-bonobo-ui.h            nautilus-undo.h \
	nautilus-clipboard.h            nautilus-view-component.h \
	nautilus-distributed-undo.h     nautilus-view-standard-main.h \
	nautilus-idle-queue.h           nautilus-view.h \
	nautilus-scroll-positionable.h"

nextheaders="nautilus-column-provider.h  nautilus-menu-item.h \
	nautilus-column.h           nautilus-menu-provider.h \
	nautilus-extension-types.h  nautilus-property-page-provider.h \
	nautilus-file-info.h        nautilus-property-page.h \
	nautilus-info-provider.h"

libndir="${STAGING_INCDIR}/libnautilus"
nextdir="${STAGING_INCDIR}/nautilus/libnautilus-extension"

do_stage() {
	install -d ${libndir} ${nextdir}
	for file in ${libnheaders}; do
		install -m 0644 libnautilus/$file ${libndir}/$file
	done

	for file in ${nextheaders}; do
		install -m 0644 libnautilus-extension/$file ${nextdir}/$file
	done

	oe_libinstall -C libnautilus-adapter libnautilus-adapter ${STAGING_LIBDIR}
	oe_libinstall -C libnautilus-extension libnautilus-extension ${STAGING_LIBDIR}
	oe_libinstall -C libnautilus-private libnautilus-private ${STAGING_LIBDIR}
	oe_libinstall -C libnautilus libnautilus ${STAGING_LIBDIR}
}

SRC_URI[archive.md5sum] = "50c5732c0c9736b7026bce1c6b0007dc"
SRC_URI[archive.sha256sum] = "83f1d6623e142af30a9b3fa9135ecf973fbb8c89f1dc36a218de0c0fef6ddf07"
