DESCRIPTION = "Twisted is an event-driven networking framework written in Python and licensed under the LGPL. \
Twisted supports TCP, UDP, SSL/TLS, multicast, Unix sockets, a large number of protocols                   \
(including HTTP, NNTP, IMAP, SSH, IRC, FTP, and others), and much more."
HOMEPAGE = "http://www.twistedmatrix.com"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "zope-interface-native zope-interface python-crypto twisted-native"
RDEPENDS = "python-core zope-interface python-pickle python-fcntl python-crypto"
PR = "r1"
SRC_URI = "http://tmrc.mit.edu/mirror/twisted/Twisted/8.2/Twisted-${PV}.tar.bz2"

S = "${WORKDIR}/Twisted-${PV}"

inherit distutils

PACKAGES += "\
  ${PN}-conch \
  ${PN}-flow \
  ${PN}-lore \
  ${PN}-mail \
  ${PN}-mail-scripts \
  ${PN}-names \
  ${PN}-news \
  ${PN}-pair \
  ${PN}-runner \
  ${PN}-scripts \
  ${PN}-trial \
  ${PN}-web \
  ${PN}-words \
  ${PN}-words-scripts \
  ${PN}-zsh \
  ${PN}-dbg \
  ${PN}-test \
"

FILES_${PN} = " \
	${bindir}/manhole \
	${bindir}/mktap \
	${bindir}/pyhtmlizer \
	${bindir}/tap2deb \
	${bindir}/tap2rpm \
	${bindir}/tapconvert \
	${bindir}/trial \
	${bindir}/twistd \
	${libdir}/${PYTHON_DIR}/site-packages/*egg-info \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/*.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/application \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/cred \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/enterprise \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/internet/*.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/internet/cfsupport/*.p* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/internet/iocpreactor/*.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/internet/iocpreactor/iocpsupport/*.p* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/manhole \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/persisted \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/__init__.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/cred_*.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_ftp.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_inet.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_manhole.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_portforward.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_socks.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_telnet.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/protocols/*.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/protocols/gps \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/protocols/mice \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/python/*.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/spread \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/tap \
"

FILES_${PN}-conch = " \
  ${bindir}/cftp \
  ${bindir}/ckeygen \
  ${bindir}/conch \
  ${bindir}/tkconch \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_conch.py* \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/conch/*.py* \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/conch/client \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/conch/insults \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/conch/openssh_compat \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/conch/ssh \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/conch/ui \
"

FILES_${PN}-flow = " \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_flow.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/flow/*.* \
"

FILES_${PN}-lore = " \
	${bindir}/lore \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_lore.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/lore/*.* \
"

FILES_${PN}-mail = " \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_mail.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/mail/*.py* \
"

FILES_${PN}-mail-scripts += " \
	${bindir}/mailmail \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/mail/scripts \
"

FILES_${PN}-names = " \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_names.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/names/*.py* \
"

FILES_${PN}-news = " \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_news.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/news/*.py* \
"

FILES_${PN}-pair = " \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_pair.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/pair/*.py* \
"

FILES_${PN}-runner = " \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/runner/portmap.so \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/runner/*.py* \
"

FILES_${PN}-scripts = " \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/scripts \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/*/scripts \
"

FILES_${PN}-trial = " \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/trial/*.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_trial.py* \
"

FILES_${PN}-web = " \
	${bindir}/websetroot \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_web.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/web/*.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/web/_auth/*.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/web/woven/*.* \
"

FILES_${PN}-words = " \
	${bindir}/im \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/plugins/twisted_words.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/words/*.py* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/words/im \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/words/protocols \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/words/xish \
"

FILES_${PN}-words-scripts = " \
	${bindir}/im \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/words/scripts \
"

FILES_${PN}-zsh = " \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/python/zsh \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/python/zshcomp.* \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/python/_twisted_zsh_stub \
"
FILES_${PN}-dbg += " \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/*/.debug \
	${libdir}/${PYTHON_DIR}/site-packages/twisted/*/*/.debug \
"

FILES_${PN}-test = " \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/test \
  ${libdir}/${PYTHON_DIR}/site-packages/twisted/*/test \
"


do_compile_prepend() {
	export PYTHONPATH=${S}/TwistedCore-${PV}
}

do_install_prepend() {
	export PYTHONPATH=${S}/TwistedCore-${PV}
}

