require flac.inc

PR = "r7"

SRC_URI += "file://disable-xmms-plugin.patch;patch=1"

do_configure_append () {
	# removes '-read-only-relocs' which is enabled for PowerPC builds.
	# It makes the build fail, other archs are not affected. Fixes #1775.
	sed -i 's/-Wl,-read_only_relocs,warning//g' src/libFLAC/Makefile
}

do_stage () {
	install -m 0644 ${S}/include/FLAC/callback.h ${STAGING_INCDIR}/FLAC/callback.h
}

SRC_URI[md5sum] = "2bfc127cdda02834d0491ab531a20960"
SRC_URI[sha256sum] = "ce4f7d11b3c04a7368c916ca4abc284dd0c0256f461dfb7f07df1ab445e7a5c0"
