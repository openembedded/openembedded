LICENSE = MIT

include nylon-feed.inc
DEPENDS = "${NYLON_FEED} \
    boost \
    db3 \
    dhcp \
    dhcp-forwarder \
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
    mc \
    net-snmp \
    openssl \
    openswan \
    openvpn \
    python \
    ppp-dsl \
    rp-pppoe \
    simple-firewall \
    thttpd \
    vsftpd \
    wget \
    wlan-ng-modules \
    zlib \
"

do_index() {
	ipkg-make-index -r ${DEPLOY_DIR_IPK}/Packages -p ${DEPLOY_DIR_IPK}/Packages -l ${DEPLOY_DIR_IPK}/Packages.filelist -m ${DEPLOY_DIR_IPK}
}

addtask index before do_build after do_install

