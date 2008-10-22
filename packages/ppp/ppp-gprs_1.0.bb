SECTION = "console/network"
DESCRIPTION = "PPP scripts for easy GPRS connection"
LICENSE = "GPL"
RDEPENDS = "ppp"
PR = "r1"

SRC_URI = "file://peers/* file://chats/*"

do_install () {
        install -d ${D}${sysconfdir}/ppp/peers/
        install -d ${D}${sysconfdir}/ppp/chats/
        install -m 0644 ${WORKDIR}/peers/* ${D}${sysconfdir}/ppp/peers/
        install -m 0644 ${WORKDIR}/chats/* ${D}${sysconfdir}/ppp/chats/

	# Add links for providers sharing same well-known config
	ln -sf _gprs-ap-internet ${D}${sysconfdir}/ppp/peers/ua-life
}

PACKAGE_ARCH = "all"

# In worst case, user may need to edit anything
CONFFILES_${PN} = "${sysconfdir}/ppp/peers/_gprs ${sysconfdir}/ppp/chats/chat-gprs"
