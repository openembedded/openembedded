DESCRIPTION = "libmikmod is a module player library supporting many formats, including mod, s3m, it, and xm."
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"

PR="r1"

DEFAULT_PREFERENCE = "-1"

TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI = "\
  http://mikmod.raphnet.net/files/libmikmod-${PV}.tar.gz \
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
	install -d ${STAGING_DATADIR}/aclocal/
	install -m 0644 libmikmod.m4 ${STAGING_DATADIR}/aclocal/
}
