DESCRIPTION = "A Curses-based mp3 player. See http://damien.degois.info/PyMP3/"
SECTION = "console/multimedia"
PRIORITY = "optional"
RDEPENDS = "python-core python-curses python-pyid3lib python-mad python-ao"
LICENSE = "GPL"
PR = "r3"

SRC_URI = "http://www.vanille.de/mirror/PyMP3-0.3.4.tar.gz"
S = "${WORKDIR}/PyMP3-0.3.4"

inherit distutils-base

PY_FILES = "box_info.py layer.py sound_ctrl.py stack.py txt_tools.py"

do_install() {
   install -d ${D}${libdir}
   install -d ${D}${libdir}/${PYTHON_DIR}
   install -d ${D}${libdir}/${PYTHON_DIR}/site-packages

   for f in ${PY_FILES}
   do
      install -m 0644 $f ${D}${libdir}/${PYTHON_DIR}/site-packages/
   done

   install -d ${D}${bindir}
   install -m 755 pymp3 ${D}${bindir}/
}

FILES_${PN} += " ${libdir}/${PYTHON_DIR}/site-packages/"

SRC_URI[md5sum] = "28e884057750aa4f0da368678e5b20bd"
SRC_URI[sha256sum] = "e534ea5505e2d0a571ca8baa4b34260953e796f6c762013756373f13411ebd6e"
