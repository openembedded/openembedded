DESCRIPTION = "GDAL is a translator library for raster geospatial data formats"
HOMEPAGE = "http://www.gdal.org/"
LICENSE = "MIT"
DEPENDS = "proj-4 sqlite3 zlib jpeg libpng tiff giflib curl jasper expat"
PR = "r3"

SRC_URI = "http://www.gdal.org/dl/${P}.tar.gz \
	   file://gdal_config.patch;patch=1 \
 	  "

ARM_INSTRUCTION_SET = "arm"

inherit autotools binconfig

EXTRA_OECONF = "--without-perl \
                --without-python \
                --without-php \
                --without-ruby \
                --with-libz=${STAGING_DIR_TARGET} \
                --with-png=${STAGING_DIR_TARGET} \
                --with-jpeg=${STAGING_DIR_TARGET} \
                --with-libtiff=${STAGING_DIR_TARGET} \
		--with-gif=${STAGING_DIR_TARGET} \
                --with-jasper=${STAGING_DIR_TARGET} \
                --with-expat=${STAGING_DIR_TARGET} \
                --with-expat-inc=${STAGING_INCDIR} \
                --with-expat-lib=${STAGING_LIBDIR} \
"

# GDAL clutter /usr/share with files instead of using a subdir :(
FILES_${PN}-dev += "${datadir}"

do_compile() {
        oe_runmake default
}

SRC_URI[md5sum] = "1939de5fe43d12884d85fa5d7797e3c2"
SRC_URI[sha256sum] = "243dabf3c45530cac8be092f9a1d838a46b46a92d4138870423006ffd6ae4001"
