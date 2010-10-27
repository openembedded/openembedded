inherit autotools

DESCRIPTION = "shows the full path of (shell) commands"
HOMEPAGE = "http://www.xs4all.nl/~carlo17/which/"
INC_PR = "0"

SRC_URI = "http://www.xs4all.nl/~carlo17/which/which-${PV}.tar.gz"

EXTRA_OECONF += "--disable-iberty"

do_configure () {
    oe_runconf
}

BBCLASSEXTEND += "native nativesdk"
