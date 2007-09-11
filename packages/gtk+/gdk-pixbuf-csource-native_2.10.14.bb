require gtk+_${PV}.bb
inherit native
DEPENDS = ""
S = "${WORKDIR}/gtk+-${PV}"
FILESPATH = "${FILE_DIRNAME}/gdk-pixbuf-csource:${FILE_DIRNAME}/gtk+-${PV}:${FILE_DIRNAME}/files"
SRC_URI += "file://reduce-dependencies.patch;patch=1"

EXTRA_OECONF = "\
  --without-x \
  --with-gdktarget=linux-fb \
  --without-libtiff \
"

do_compile() {
	cd gdk-pixbuf && oe_runmake
}

do_stage() {
	cd gdk-pixbuf && oe_runmake install
}

do_install() {
	:
}

