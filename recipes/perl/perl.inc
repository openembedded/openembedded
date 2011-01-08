# helper functions for perl
def all_perl_packages(d):
    depchains = (d.getVar("DEPCHAIN_POST", True) or "").split()
    blacklist = ["perl-modules", "perl-misc", "perl-pod", "perl-doc", "perl-module-cpanplus-internals-source-sqlite", "perl-module-cpanplus-internals-source-sqlite-tie"]
    for pkg in d.getVar("PACKAGES", True).split():
        if not pkg in blacklist and not any(pkg.endswith(post) for post in depchains):
            yield pkg

