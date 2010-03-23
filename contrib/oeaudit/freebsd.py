"""
Handle FreeBSD port audit files and map the names to OpenEmbedded
"""

class freebsd_info:
    """
    Handles an entry like the one below:
    vulnerability-test-port>=2000<2010.02.26|http://cvsweb.freebsd.org/ports/security/vulnerability-test-port/|Not vulnerable, just a test port (database: 2010-02-26)
    """
    def __init__(self, name, versions, link, kind):
        self.name = name
        self.versions = versions
        self.link = link

    @classmethod
    def split_versions(self, input):
        """
        Split versions by <, >, >=, >=
        """
        versions = []
        last_pos = 0

        # Try to determine <, >, >=, <=
        # we will have to carry stuff on to find the
        # version..
        i = 0
        while i < len(input) - 1:
            c1 = input[i]
            c2 = input[i+1]
            if c1 != '<' and c1 != '>' and c1 != '=':
                i = i + 1
                continue

            # is a '=' coming behind it?
            next = i + 1
            if c2 == '=':
                next = next + 1

            # submit
            if last_pos != 0:
                versions.append((next_type, input[last_pos:i]))

            # remember stuff
            next_type = input[i:next]
            last_pos = next
            i = next

        assert last_pos != 0
        versions.append((next_type, input[last_pos:len(input)]))
        return versions

    def __repr__(self):
        return "%s: %s" % (self.name, self.versions)


def map_names(str):
    """Map a FreeBSD name to OE"""
    maps = {
        "libpurple" : "pidgin",
        "php4" : "php",
        "php5" : "php",
        "expat2" : "expat",
        "freeciv-gtk" : "freeciv",
        "pcre" : "libpcre",
        "vim-gnome" : "vim",
        "python23" : "python",
        "python24" : "python",
        "python25" : "python",
        "python+ipv6" : "python",
        "wget-devel" : "wget",
        "xchat2" : "xchat",
        "freetype" : "freetype",
        "qemu-devel" : "qemu",
        "krb5-beta" : "krb5",
        "freeciv-gtk2": "freeciv",
        "gtk" : "gtk+",
        "wget+ipv6" : "wget",
        "ja-gd" : "gd",
        "openvpn-devel" : "openvpn",
        "mpeg123-esound" : "mpeg123",
        "mpeg123-nas" : "mpeg123",
        "cdrtools-cjk" : "cdrtools",
        "apache+mod_ssl+mod_deflate" : "apache2",
        "apache+mod_ssl*" : "apache2",
        "vim-gtk2" : "vim",
        "zh-emacs" : "emacs",
        "{ja-,}bugzilla" : "bugzilla",
        "zh-tin" : "tin",
        "mozilla+ipv6": "mozilla",
        "mozilla-embeddded" : "mozilla",
        "rar" : "unrar",
        "libsndfile" : "libsndfile1",
        "sylpheed-gtk2": "sylpheed",
        "cdrtools-devel": "cdrtools",
        "pine4-ssl": "pine",
        "apache" : "apache2",
        "ghostscript-gpl" : "gs",
        "ghostscript-gnu-nox11" : "gs",
        "ghostscript8" : "gs",
        "ghostscript-afpl-nox11" : "gs",
        "ghostscript-afpl" : "gs",
        "isc-dhcp" : "dhcp",
        "mplayer-gtk" : "mplayer",
        "xerces-c2" : "xerces-c",
        "libxml" : "libxml2",
        "vim+ruby" : "vim",
        "mplayer{,-gtk}{,-esound}" : "mplayer",
        "proftpd-devel": "proftpd",
        "neon28" : "neon",
        "php4-dba" : "php",
        "php5-{cgi,cli}" : "php",

    }

    try:
        return maps[str]
    except:
        return str

def is_not_in_oe(name):
    """Method to reject packages not in OE"""
    not_in = [
        # packages that we will never have...
        "linux-firefox", "fr-linux-netscape", "linux-netscape-{communicator,navigator}",
        "linux_base", "ja-netscape7", "{ja,ko}-netscape-{communicator,navigator}-linux", "zhTW-linux-mozillafirebird", "ja-linux-mozillafirebird-gtk1", "el-linux-mozillafirebird", "mozilla-firebird", "netscape7",
        "acroread4", "acroread7", "acroread5",
        "linux-openmotif", "linux-flock", "linux-jdk", "linux-curl", "linux-png", "linux-firefox-devel",

        # packages that we don't have now but maybe will have in
        # the future and blacklisting them here might be a problem
        "openoffice.org-2-devel", "openoffice.org-2", "it-openoffice", "ca-openoffice","sl-openoffice-SI", "ja-openoffice",
        "drupal4", "drupal5", "drupal6", "drupal-pubcookie",
        "gpdf",
        "nagios",
        "kdenetwork", "ja-kdelibs", "kdegraphics", "kdepim", "kdebase4-runtime",
        "xemacs-devel", "xemacs-devel-21.5", "xemacs-mule", "zh-xemacs", "zh-xemacs-mule",
        "geeklog", "apach13-ssl", "nvidia-driver", "eGroupWare", "varnish", "heimdal",
        "bugzilla", "agenda-snow-libs", "mozilla",
    ]

    return name in not_in

def create_infos(line):
    split = line.split("|")
    for i in range(0, len(split[0])):
        c = split[0][i]
        if c != '<' and c != '=' and c != '>':
                continue
        name = map_names(split[0][0:i])
        versions = freebsd_info.split_versions(split[0][i:])
        break

    if is_not_in_oe(name):
        #print "Not in oe %s" % name
        return []

    link = split[1]
    kind = split[2]
    return [freebsd_info(name, versions, link, kind)]


def read_auditfile(filename):
    """
    Read an uncompressed audit file from freebsd
    """
    f = open(filename)
    packages = {}
    for line in f:
        if line.startswith("#"):
            continue

        infos = create_infos(line)
        for info in infos:
            try:
                packages[info.name].append(info)
            except:
                packages[info.name] = []
                packages[info.name].append(info)
    return packages


def prepare_version(bsd_version):
    """
    FreeBSD is adding ,1 for revisions.. remove that
    """
    # FIXME return a tuple with a revision...
    rev = "r0"
    split = bsd_version.rsplit(',', 1)
    split = split[0]
    split = split.rsplit('_', 1)
    if len(split) == 2:
        rev = "r%s" % split[1]
    return (split[0], rev)

