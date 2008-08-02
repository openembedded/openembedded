require flac.inc

PR = "r6"

do_configure_append () {
	# removes '-read-only-relocs' which is enabled for PowerPC builds.
	# It makes the build fail, other archs are not affected. Fixes #1775.
	sed -i 's/-Wl,-read_only_relocs,warning//g' src/libFLAC/Makefile
}

do_stage_append () {
	install -m 0644 ${S}/include/FLAC/callback.h ${STAGING_INCDIR}/FLAC/callback.h
}
