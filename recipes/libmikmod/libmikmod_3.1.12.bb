DESCRIPTION = "libmikmod is a module player library supporting many formats, including mod, s3m, it, and xm."
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
PR = "r1"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/mikmod/libmikmod-${PV}.tar.gz \
  file://m4.patch;patch=1 \
  file://autofoo.patch;patch=1 \
"

inherit autotools binconfig

EXTRA_OECONF = "\
  --disable-af \
  --enable-alsa \
  --disable-esd \
  --enable-oss \
  --disable-sam9407 \
  --disable-ultra \
  --disable-esdtest \
  --enable-threads \
"

do_stage() {
	oe_libinstall -a -so -C libmikmod libmikmod ${STAGING_LIBDIR}
	install -m 0644 ${S}/include/mikmod.h ${STAGING_INCDIR}/

	install -d ${STAGING_BINDIR_CROSS}
        cat libmikmod-config | sed 's,$libdir , ,' \
                             | sed 's,$includes , ,' > ${STAGING_BINDIR_CROSS}/libmikmod-config
        chmod a+rx ${STAGING_BINDIR_CROSS}/libmikmod-config
	install -d ${STAGING_DATADIR}/aclocal/
	install -m 0644 libmikmod.m4 ${STAGING_DATADIR}/aclocal/
}
