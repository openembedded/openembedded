# Meta file to inform the autobuilder which packages to build for the feeds
# Any changes should be discussed first on the angstrom-distro-devel mailinglist

# Try to keep it alphabetically sorted please
 
inherit meta

RDEPENDS = ""

# Basic tools
RDEPENDS += " \
         task-proper-tools \
	 screen \
	 "

# Browsers know to work on all archs
RDEPENDS += " \
         gpe-mini-browser \
         midori \
	 minimo \
         openmoko-browser2 \
	 webkit-gtklauncher \
         "

# Webservers
RDEPENDS += " \
        apache2 \
        boa \
	cherokee \
	lighttpd \
	thttpd \
	"
