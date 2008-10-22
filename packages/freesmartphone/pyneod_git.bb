DESCRIPTION = "Zad - daemons"
HOMEPAGE = "http://neo1973-germany.de/wiki/Zad"
AUTHOR = "M. Dietrich"
SECTION = "console/network"
DEPENDS = "python"
LICENSE = "GPL"
PV = "0.0.0+gitr${SRCREV}"
PR = "r0"

inherit update-rc.d

INITSCRIPT_NAME = "pyneod"
INITSCRIPT_PARAMS = "defaults 40"

SRC_URI = "${FREESMARTPHONE_GIT}/pyneo.git;protocol=git;branch=master"
S = "${WORKDIR}/git/pyneod"

export D := "${D}"
export PREFIX = "${prefix}"

do_compile() {
	:
}

do_install() {
	python setup.py
}

RCONFLICTS = "gsmd"
RREPLACES = "gsmd"
RDEPENDS = "\
  python-codecs \
  python-compression \
  python-crypt \
  python-curses \
  python-datetime \
  python-dbus \
  python-fcntl \
  python-gdbm \
  python-gst \
  python-html \
  python-io \
  python-lang \
  python-logging \
  python-math \
  python-mime \
  python-netclient \
  python-netserver \
  python-pickle \
  python-pprint \
  python-pycrypto \
  python-pygobject \
  python-pyserial \
  python-re \
  python-readline \
  python-shell \
  python-simplejson \
  python-sqlite3 \
  python-stringold \
  python-syslog \
  python-threading \
  python-xml \
  python-zlib \
"

FILES_${PN} = "${datadir} ${sysconfdir} ${bindir}"
PACKAGE_ARCH = "${MACHINE_ARCH}"
