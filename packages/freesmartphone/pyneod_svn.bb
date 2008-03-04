DESCRIPTION = "FIC Neo Smartphone daemons implementing the freesmartphone.org dbus APIs"
AUTHOR = "M. Dietrich"
SECTION = "console/network"
DEPENDS = "python"
LICENSE = "GPL"
PV = "0.0+svnr${SRCREV}"
PR = "r3"

inherit update-rc.d

INITSCRIPT_NAME = "pyneod"
INITSCRIPT_PARAMS = "defaults 40"

SRC_URI = "svn://projects.linuxtogo.org/svn/smartphones/trunk/software;module=pyneod"
S = "${WORKDIR}/pyneod"

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
