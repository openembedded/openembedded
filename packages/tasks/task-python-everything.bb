DESCRIPTION= "Everything Python"
HOMEPAGE = "http://www.vanille.de/projects/python.spy"
LICENSE = "MIT"
PR = "ml22"

RDEPENDS = "\
		python-ao 		\
		python-cheetah		\
		python-constraint	\
		python-dbus			\
		python-dialog		\
		python-pydirectfb		\
		python-efl			\
		python-pycurl		\
		python-fam			\
		python-fnorb		\
		python-formencode	\
		python-fpconst		\
		python-fuse			\
		python-gmpy		\
		python-gnosis		\
		python-gst		\
		python-hmm		\
		python-imaging		\
		python-imdbpy		\
		python-inotify		\
		python-irclib		\
		python-itools		\
		python-logilab-common		\
		python-libgmail		\
		python-lxml		\
		python-mad		\
		python-numarray		\
		python-numeric		\
		python-ogg		\
		python-pexpect		\
		python-pybluez		\
		python-pycairo		\
		python-pychecker	\
		python-pycodes		\
		python-pyephem		\
		python-pyfits		\
		python-pyflakes		\
		python-pygame		\
		python-pygobject	\
		python-pygoogle		\
		python-pygtk-1.2	\
		python-pygtk		\
		python-pyid3lib		\
		python-pyiw		\
		python-pylinda		\
		python-pylint		\
		python-pyqt			\
		python-pyraf		\
		python-pyreverse	\
		python-pyrex		\
		python-pyro		\
		python-pyserial		\
		python-pytester		\
		python-pyusb		\
		python-pyvisa		\
		python-pyweather	\
		python-pyxml		\
		python-pyxmlrpc		\
		python-scapy		\
		python-scons		\
		python-setuptools	\
		python-simplejson	\
		python-sip		\
		python-sgmlop		\
		python-snmplib		\
		python-soappy		\
		python-spydi		\
		python-spyro		\
		python-sqlobject	\
		python-sword		\
		python-tlslite		\
		python-urwid		\
		python-vmaps		\
		python-vorbis		\
		python-webpy		\
		moin			\
		plone			\
		twisted			\
		zope"

BROKEN_PACKAGES = "\
		python-egenix-mx-base \
		python-gammu \
		python-m2crypto \
		python-mysqldb \
        python-pyqwt        \
"

#fixme add python-pycap once libdnet is in again
#fixme add python-pyx once kpathwhich-native is there
#fixme add packages dynamically
LICENSE = "MIT"
