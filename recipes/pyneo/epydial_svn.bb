DESCRIPTION = "epydial"
HOMEPAGE = "http://neo1973-germany.de/epydial"
AUTHOR = "fgau"
LICENSE = "GPL3"
SECTION = "python/ui"
DEPENDS = "edje"
PV = "1.0+svnr${SRCREV}"
PR = "r0"

SRC_URI = "svn://neo1973-germany.de/svn;proto=http;module=epydial"
S = "${WORKDIR}/${PN}"

do_compile() {
	./compile_theme
}

do_install() {
	install -m 0755 -d ${D}/etc/X11/Xsession.d/
	install -m 0755 ${S}/80${PN} ${D}/etc/X11/Xsession.d/
	install -m 0755 -d ${D}/usr/share/${PN}/
	install -m 0644 ${S}/*.py ${D}/usr/share/${PN}/
	install -m 0755 -d ${D}/usr/share/${PN}/data/
	install -m 0755 -d ${D}/usr/share/${PN}/data/themes/
	for n in data/themes/*/*.edj; do
		install -m 0755 -d ${D}/usr/share/${PN}/`dirname $n`
		install -m 0644 ${S}/$n ${D}/usr/share/${PN}/`dirname $n`
	done
}

RDEPENDS = "\
  task-python-efl \
  pyneod \
  pyneo \
"
