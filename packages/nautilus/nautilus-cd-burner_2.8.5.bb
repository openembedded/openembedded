# nautilus-cd-burner OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

inherit gnome
LICENSE="GPL"

DEPENDS="nautilus"

SRC_URI += "file://makefile.patch;patch=1"

EXTRA_OECONF = "--disable-gtk-doc"

PACKAGES += "libnautilus-burn"

FILES_${PN} = "/usr/share/* /usr/bin/* /etc /usr/lib/gnome-vfs-2.0/* \
	/usr/lib/nautilus/*"
FILES_libnautilus-burn="/usr/lib/*.so*"

headers="bacon-cd-selection.h  cd-drive.h  cd-recorder.h"
hdir="${STAGING_INCDIR}/libnautilus-burn"

do_stage() {
	install -d ${hdir}
	for file in ${headers}; do
		install -m 0644 $file ${hdir}/$file
	done

	oe_libinstall libnautilus-burn  ${STAGING_LIBDIR}
}
