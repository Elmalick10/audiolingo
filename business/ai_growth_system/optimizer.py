def optimize(data):

    if data["views"] < 1000:
        return "changer_hook"

    if data["watch_time"] < 3:
        return "video_trop_longue"

    return "bon_format"