DESCRIPTION = "Everything Python for SharpROM"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
HOMEPAGE = "http://www.vanille.de/projects/python.spy"
LICENSE = "MIT"
PR = "ml4"

NONWORKING = "\
		python-codes		\
		python-crypto		\
		python-gammu		\
		python-gmpy		\
		python-pybluez		\
		python-pysqlite		\
		python-pygtk		\
		python-pyqwt		\
		python-sgmlop		\
		python-sword            \
		python-vorbis"

RDEPENDS = "\
		python-ao 		\
		python-constraint	\
		python-dialog		\
		python-egenix-mx-base   \
		python-fnorb		\
		python-fpconst		\
		python-gnosis		\
		python-hmm		\
		python-irclib		\
		python-itools		\
		python-libgmail		\
		python-logilab		\
		python-mad		\
		python-native		\
		python-numeric		\
		python-numarray		\
		python-ogg		\
		python-pexpect		\
		python-pychecker	\
		python-pycurl		\
		python-pyfits		\
		python-pyflakes		\
		python-pygoogle		\
		python-pylinda		\
		python-pylint		\
		python-pyqt		\
		python-pyraf		\
		python-pyreverse	\
		python-pyro		\
		python-pyserial		\
		python-pyvisa		\
		python-pyweather	\
		python-pyxml		\
		python-pyxmlrpc		\
		python-quicklauncher    \
		python-scapy		\
		python-scons		\
		python-sip		\
		python-snmplib		\
		python-soappy		\
		python-spydi		\
		python-spyro		\
		python-tlslite		\
		python-urwid		\
		python-vmaps		\
		moin			\
		plone			\
		twisted			\
		zope"

#fixme add python-pycap once libdnet is in again
#fixme add python-pyx once kpathwhich-native is there
#fixme add packages dynamically
#fixme python-numarray doesn't work with soft-float
