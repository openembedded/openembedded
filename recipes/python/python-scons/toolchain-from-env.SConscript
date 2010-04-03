#toolchain-from-env

import os
env['CC'] = os.environ['CC']
env['CXX'] = os.environ['CXX']
env['CPP'] = os.environ['CPP']
env['AR'] = os.environ['AR']
env['LD'] = os.environ['LD']
env['CCLD'] = os.environ['CCLD']
env['ENV']['PATH'] = os.environ['PATH']

env['LINKFLAGS'] = os.environ['TARGET_LINK_HASH_STYLE'] + " " + env['LINKFLAGS']
