DESCRIPTION = "Everything Python for SharpROM"
HOMEPAGE = "http://www.vanille.de/projects/python.spy"
LICENSE = "MIT"
PR = "ml7"

NONWORKING = "\
		python-codes		\
		python-crypto		\
		python-gammu		\
		python-gmpy		\
		python-hmm		\
		python-itools		\
		python-pybluez		\
		python-pyreverse	\
		python-pysqlite		\
		python-pygtk		\
		python-pyqwt		\
		python-snmplib		\
		python-sgmlop		\
		python-spyro		\
		python-sword            \
		python-urwid		\
		python-vorbis		\
		python-vmaps"

RDEPENDS_${PN} = "\
		python-ao 		\
		python-constraint	\
		python-dialog		\
		python-fnorb		\
		python-fpconst		\
		python-gnosis		\
		python-irclib		\
		python-libgmail		\
		python-logilab-common	\
		python-lxml		\
		python-mad		\
		python-native		\
		python-numeric		\
		python-numarray		\
		python-ogg		\
		python-pexpect		\
		python-pychecker	\
		python-pycurl		\
		python-pyephem		\
		python-pyfits		\
		python-pyflakes		\
		python-pygoogle		\
		python-pylinda		\
		python-pylint		\
		python-pyqt		\
		python-pyraf		\
		python-pyro		\
		python-pyserial		\
		python-pyvisa		\
		python-pyweather	\
		python-pyxml		\
		python-pyxmlrpc		\
		python-scapy		\
		python-scons		\
		python-sip		\
		python-soappy		\
		python-spydi		\
		python-tlslite		\
		python-twisted		\
		python-webpy		\
		moin			\
		plone			\
		zope"

#fixme add python-egenix-mx-base if brought in from nonworking
#fixme add python-pycap once libdnet is in again
#fixme add python-pyx once kpathwhich-native is there
#fixme add packages dynamically
#fixme python-numarray doesn't work with soft-float
