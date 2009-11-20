# Copyright (C) 2009 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "OpenSCADA system is open implementation SCADA (Supervisory controll and data acquisition) systems"
HOMEPAGE = "http://oscada.org.ua/"
LICENSE = "GPL"
SECTION = "Applications"
DEPENDS = "gd mysql expat sqlite3 lmsensors-apps fftw qt4-x11-free"
#SRC_URI = "ftp://ftp.oscada.org/OpenSCADA/0.6.4/openscada-0.6.4.tar.gz"
SRC_URI = "svn://oscada.org.ua/trunk;module=OpenSCADA;rev=;proto=svn \
           file://rcc-moc.patch;patch=1 \
          "

PV = "0.6.4+svnr${SRCPV}"

S = "${WORKDIR}/OpenSCADA"

inherit autotools_stage

EXTRA_OECONF = " \
      --includedir=${STAGING_INCDIR} \
      --oldincludedir=${STAGING_INCDIR} \
      --disable-SQLite \
      --disable-MySQL \
      --disable-FireBird \
      --without-sqlite3 \
      --without-firebird \
      --disable-SoundCard \
      --disable-Vision \
      --disable-WebVision \
      --disable-shared \
"

#do_configure_prepend() {
#  autoconf
#}

#do_configure() {
#  oe_runconf
#}


do_install_prepend () {
  mkdir -p -m 755 ${D}/etc
  cp ${S}/data/oscada.xml ${D}/etc
  mkdir -p -m 755 ${D}/var/spool/openscada/icons
  cp ${S}/data/icons/* ${D}/var/spool/openscada/icons
  install -p -m 777 -d ${D}/var/spool/openscada/ARCHIVES/{MESS,VAL}
}

