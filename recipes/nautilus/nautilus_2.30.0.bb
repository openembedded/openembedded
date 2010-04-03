# nautilus OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

inherit gnome

SRC_URI += "file://idl-sysroot.patch;patch=1 \
            file://no-try-run-strftime.diff;patch=1 \
"

SRC_URI[archive.md5sum] = "e09aea66166c0a90d09955bd4d2672be"
SRC_URI[archive.sha256sum] = "01ecbc4b8b9a0ac726194eb81d3de7080ee52d885eb1898692aa951b093731a5"

export SYSROOT = "${STAGING_DIR_HOST}"

LICENSE="GPL"

DEPENDS += "libunique  gvfs tracker librsvg libexif eel esound gnome-desktop orbit2-native"
RDEPENDS = "gvfs gvfsd-ftp gvfsd-sftp gvfsd-trash"

EXTRA_OECONF = " --disable-gtk-doc  --disable-update-mimedb "

PACKAGES += " libnautilus"

FILES_${PN} += "${datadir}/icons  /usr/libexec/ "
FILES_libnautilus = "/usr/lib/*.so*"
FILES_${PN}-dbg += "/usr/libexec/.debug"

do_configure_prepend() {
	sed -i -e /docs/d Makefile.am
}

# We need native orbit-idl with target idl files. No way to say it in a clean way:
do_configure_append () {
	find -name Makefile -exec sed -i '/\/usr\/bin\/orbit-idl-2/{s:/usr/bin:${STAGING_BINDIR_NATIVE}:;s:/usr/share:${STAGING_DATADIR}:g}' {} \;
}

