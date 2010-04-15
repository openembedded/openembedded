require gnome-desktop.inc

PR = "r1"

inherit gnome

EXTRA_OECONF = ""
EXTRA_AUTORECONF = "-I ${STAGING_DATADIR}/aclocal/gnome2-macros"

SRC_URI[archive.md5sum] = "16691f6bdc7c09445c457387adaba1f1"
SRC_URI[archive.sha256sum] = "6a1499a1e50ac89210a9a1fdb36bc070ef6d1a02764a0f8d90de314dba01972e"
