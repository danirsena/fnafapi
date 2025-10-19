package com.danirsena.fnafAPI.security

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

@Component
class ApiKeyFilter : OncePerRequestFilter() {
    @Value("\${API_KEY}")
    private val apiKey: String? = null

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val method = request.getMethod()

        // Só proteger métodos sensíveis
        if (method == "POST" || method == "PUT" || method == "DELETE") {
            val requestKey = request.getHeader("X-API-KEY")

            if (requestKey == null || requestKey != apiKey) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED)
                response.getWriter().write("Unauthorized: Invalid or missing API key")
                return
            }
        }

        filterChain.doFilter(request, response)
    }
}