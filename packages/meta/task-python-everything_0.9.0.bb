DESCRIPTION= "Everything Python"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "r7"
DEPENDS = "	python-ao 		\
		python-constraint	\
		python-crypto		\
		python-dialog		\
		python-egenix-mx-base   \
		python-pycurl		\
		python-fnorb		\
		python-fpconst		\
		python-gmpy		\
		python-gnosis		\
		python-hmm		\
		python-irclib		\
		python-irclib		\
		python-logilab		\
		python-libgmail		\
		python-mad		\
		python-native		\
		python-numeric		\
		python-ogg		\
		python-pexpect		\
		python-pychecker	\
		python-pycodes		\
		python-pygame		\
		python-pygoogle		\
		python-pygtk		\
		python-pylinda		\
		python-pylint		\
		python-pyqt		\
		python-pyqwt		\
		python-pyreverse	\
		python-pyro		\
		python-pyserial		\
		python-pyxml		\
		python-pyxmlrpc		\
		python-quicklauncher    \
		python-scapy		\
		python-scons		\
		python-sip		\
		python-sgmlop		\
		python-snmplib		\
		python-soappy		\
		python-pysqlite		\
		python-tlslite		\
		python-urwid		\
		python-vmaps		\
		python-vorbis		\
		moin			\
		plone			\
		twisted			\
		zope"
RDEPENDS=${DEPENDS}

#fixme add python-pycap once libdnet is in again
#fixme add python-pyx once kpathwhich-native is there
#fixme add packages dynamically
#fixme python-numarray doesn't work with soft-float
LICENSE = MIT
