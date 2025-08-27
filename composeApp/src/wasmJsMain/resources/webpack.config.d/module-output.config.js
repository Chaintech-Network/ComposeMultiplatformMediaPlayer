config.output.library = {
    type: "module"
};

config.experiments = {
    ...(config.experiments || {}),
    outputModule: true
};
