# nautilus OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

inherit gnome

SRC_URI += "file://idl-sysroot.patch;patch=1"
export SYSROOT = "${STAGING_DIR_HOST}"

LICENSE="GPL"

PR = "r1"

DEPENDS += " gvfs tracker librsvg libexif eel esound gnome-desktop orbit2-native"
RDEPENDS = "gvfs"

EXTRA_OECONF = " --disable-gtk-doc  --disable-update-mimedb "

PACKAGES += " libnautilus"

FILES_${PN} += "${datadir}/icons  /usr/libexec/ "
FILES_libnautilus = "/usr/lib/*.so*"
FILES_${PN}-dbg += "/usr/libexec/.debug"

# We need native orbit-idl with target idl files. No way to say it in a clean way:
do_configure_append () {
	find -name Makefile -exec sed -i '/\/usr\/bin\/orbit-idl-2/{s:/usr/bin:${STAGING_BINDIR_NATIVE}:;s:/usr/share:${STAGING_DATADIR}:g}' {} \;
}

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "783e5f7be6391d6c46b4725e38af475a"
SRC_URI[archive.sha256sum] = "a793ebe4245656f0ae23d5a87895555182f62943e02e9667303ad20c4e690c1d"
