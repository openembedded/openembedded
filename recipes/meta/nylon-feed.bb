LICENSE = "MIT"

include nylon-feed.inc
DEPENDS = "${NYLON_FEED} \
    db3 \
    expat \
    glib-2.0 \
    glibc \
    gmp \
    iproute2 \
    libcgicc \
    libedit \
    libmail-sendmail-perl \
    libnetserver-generic-perl \
    libpcre \
    lzo \
    make \
    mystun-server \
    openssl \
    openswan \
    openvpn \
    ppp-dsl \
    rp-pppoe \
    simple-firewall \
    thttpd \
    wget \
    zlib \
"

# vsftpd \
#

do_index() {
	touch ${DEPLOY_DIR_IPK}/Packages
	ipkg-make-index -r ${DEPLOY_DIR_IPK}/Packages -p ${DEPLOY_DIR_IPK}/Packages -l ${DEPLOY_DIR_IPK}/Packages.filelist -m ${DEPLOY_DIR_IPK}
}

addtask index before do_build after do_install

