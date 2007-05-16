require clamav.inc
PR = "r0"

# 0.9x requires curl for incremental database updates
DEPENDS += "curl"

# Don't check for clamav uid/gid - they don't exist on the host
# Put virus definitions in /var/lib not /usr/lib
EXTRA_OECONF = "--disable-clamav \
                --with-zlib=${STAGING_DIR}/${HOST_SYS} \
                --with-libcurl \
                --with-dbdir=${localstatedir}/lib/clamav"

# Package up configuration utility - new for 0.9x
PACKAGES += "${PN}-clamconf"
FILES_${PN}-clamconf = "${bindir}/clamconf"
