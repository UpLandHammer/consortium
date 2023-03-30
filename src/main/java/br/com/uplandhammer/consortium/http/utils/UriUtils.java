package br.com.uplandhammer.consortium.http.utils;

import lombok.experimental.UtilityClass;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@UtilityClass
public class UriUtils {
    public static URI generateResourceUriLocation(UriComponentsBuilder uriComponentsBuilder, String apiPath, Long idResource) {
        return uriComponentsBuilder.path(apiPath).buildAndExpand(idResource).toUri();
    }
}
