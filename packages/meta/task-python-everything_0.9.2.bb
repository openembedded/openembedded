DESCRIPTION= "Everything Python"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
HOMEPAGE = "http://www.vanille.de/projects/python.spy"
LICENSE = "MIT"
PR = "ml1"

DEPENDS = "\
		python-ao 			\
		python-bluez		\
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
		python-inotify		\
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
		python-pygtk2		\
		python-pylinda		\
		python-pylint		\
		python-pyqt		\
		python-pyqwt		\
		python-pyreverse	\
		python-pyrex		\
		python-pyro		\
		python-pyserial		\
		python-pytest		\
		python-pyweather	\
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
		python-pysqlite2	\
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
