DESCRIPTION = "A Curses-based mp3 player. See http://damien.degois.info/PyMP3/"
SECTION = "console/multimedia"
PRIORITY = "optional"
MAINTAINER = "Jason Haslup <openembedded@haslup.com>"
RDEPENDS = "python-core python-ncurses python-pyid3lib python-mad python-ao"
PR = "r1"
LICENSE = "GPL"
SRC_URI = "http://damien.degois.info/PyMP3/PyMP3-0.3.4.tar.gz"
S = "${WORKDIR}/PyMP3-0.3.4"

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
