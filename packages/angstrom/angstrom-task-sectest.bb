DESCRIPTION = "Task packages for the Angstrom distribution"
PR = "r33"

inherit task

RDEPENDS_${PN} = "\
    nmap \
    ettercap-ng \
    stunnel \
    curl \
#    dsniff \
    prismstumbler \
#    tcpdump \
    kismet \
    hydra \
#    thcrut \
#    driftnet \
    miniclipboard"
