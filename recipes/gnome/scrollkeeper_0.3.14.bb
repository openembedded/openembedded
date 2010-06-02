DESCRIPTION = "This is the Scrollkeeper Open Documentation Cataloging System."
LICENSE = "LGPLv2.1/GFDL"

DEPENDS = "libxml2 libxslt"

inherit gnome gettext

SRC_URI[archive.md5sum] = "b175e582a6cec3e50a9de73a5bb7455a"
SRC_URI[archive.sha256sum] = "ece1987169d136aa148dc02f1e4784cbe5d1a21cf6725039547f1417e4ebc122"

BBCLASSEXTEND = "native"

